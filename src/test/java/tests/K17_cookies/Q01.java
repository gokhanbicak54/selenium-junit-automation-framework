package tests.K17_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_Each;

import java.util.Set;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() {

        // 1- google anasayfaya gidin.
        driver.get("https://www.google.com");

        // 2- cookies cikarsa kabul edin.
        // 3- Sayfadaki cookies sayisinin 3’veya daha fazla oldugunu test edin.
        Set<Cookie> sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("Sayfadaki cookie sayisi: " + sayfadakiCookieSeti.size());
        int expectedCookieSayisi = 4;
        int actualCookieSayisi = sayfadakiCookieSeti.size();
        Assertions.assertEquals(expectedCookieSayisi, actualCookieSayisi);

        // 4- sayfadaki cookie'leri yazdirin.
        System.out.println(sayfadakiCookieSeti);

        // 5- cookie'lerin isimlerini yazdirin.
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie);
        }
        System.out.println("=============================");
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        // 6- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin.
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("=============================");
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        // 7- eklediginiz cookie’nin sayfaya eklendigini test edin.
        Assertions.assertTrue(sayfadakiCookieSeti.contains(yeniCookie));

        // 8- ismi NID olan cookie’yi silin ve silindigini test edin.
        driver.manage().deleteCookieNamed("NID");
        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("=============================");
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(eachCookie.getName());
        }

        Assertions.assertFalse(sayfadakiCookieSeti.contains("NID"));

        // 9- tum cookie’leri silin ve silindigini test edin.
        driver.manage().deleteAllCookies();
        sayfadakiCookieSeti = driver.manage().getCookies();
        Assertions.assertEquals(0, sayfadakiCookieSeti.size());
    }
}