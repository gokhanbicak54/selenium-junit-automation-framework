package tests.K17_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_Each;

import java.util.Set;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Google anasayfaya gidin.
        driver.get("https://www.google.com");

        // 2- Cookies cikarsa kabul edin.
        // 3- Sayfadaki cookies sayisinin 3 veya daha fazla oldugunu test edin.
        Set<Cookie> sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("Sayfadaki Cookie Sayisi: " + sayfadakiCookieSeti.size()); // 4
        int expectedCookieSayisi = 4;
        int actualCookieSayisi = sayfadakiCookieSeti.size();
        Assertions.assertEquals(expectedCookieSayisi, actualCookieSayisi);

        // 4- Sayfadaki cookie'leri yazdirin.
        System.out.println(sayfadakiCookieSeti);
        System.out.println("=======================");

        // 5- Cookie'lerin isimlerini yazdirin.
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        // 6- Ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin.
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("=======================");
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        // 7- Eklediginiz cookie’nin sayfaya eklendigini test edin.
        Assertions.assertTrue(sayfadakiCookieSeti.contains(yeniCookie));

        // 8- Ismi AEC olan cookie’yi silin ve silindigini test edin.
        driver.manage().deleteCookieNamed("AEC");
        sayfadakiCookieSeti = driver.manage().getCookies();
        Assertions.assertFalse(sayfadakiCookieSeti.contains("AEC"));
        System.out.println("=======================");
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        // 9- Tum cookie’leri silin ve silindigini test edin.
        driver.manage().deleteAllCookies();
        sayfadakiCookieSeti = driver.manage().getCookies();
        Assertions.assertEquals(0, sayfadakiCookieSeti.size());
    }
}