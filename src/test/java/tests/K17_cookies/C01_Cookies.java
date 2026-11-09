package tests.K17_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies  extends TestBase_Each {

    @Test
    public void test01() {

        // Google anasayfaya gidin.
        driver.get("https://www.google.com");

        // Cookies cikarsa kabul edin.
        driver.findElement(By.xpath("//div[.='Accept all']"))
                .click();
        ReusableMethods.wait(1);

        // Sayfada kac adet cookies bulundugunu yazdirin.
        Set<Cookie> sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("Sayfadaki cookie sayisi: " + sayfadakiCookieSeti.size());

        // Sayfadaki cookie'leri yazdirin.
        System.out.println(sayfadakiCookieSeti);

        // Daha anlasilir olmasi icin bir for-each loop ile cookie'leri yazdiralim.
        System.out.println("===============");
        int siraNo = 1;
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(siraNo + ". cookie: " + eachCookie);
            siraNo++;
        }

        // Cookie'lerin isimlerini yazdirin.
        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(siraNo + ". cookie ismi: " + eachCookie.getName());
            siraNo++;
        }

        // Ismi SOCS olan cookie'nin degerinin "CAISHAgBEhJnd3NfMjAyNDEyMTAtMF9SQzEaAmVuIAEaBgiAuPi6Bg" oldugunu test edin.
        String expectedDeger = "CAISHAgBEhJnd3NfMjAyNDEyMTAtMF9SQzEaAmVuIAEaBgiAuPi6Bg";
        String actualDeger = driver.manage().getCookieNamed("SOCS").getValue();
        Assertions.assertEquals(expectedDeger, actualDeger);

        // Ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup sayfaya ekleyin.
        Cookie yeniCookie = new Cookie("enSevdigimCookie","cikolataliCookie");
        driver.manage().addCookie(yeniCookie);

        // Tum cookie'leri yazdiralim.
        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(siraNo + ". cookie: " + eachCookie);
            siraNo++;
        }

        // Cookie'yi ekleyebildigimizi test edin.
        Assertions.assertTrue(sayfadakiCookieSeti.contains(yeniCookie));

        // Ismi SOCS olan cookie'yi silin.
        driver.manage().deleteCookieNamed("SOCS");

        sayfadakiCookieSeti = driver.manage().getCookies();
        System.out.println("===============");
        siraNo = 1;
        for (Cookie eachCookie : sayfadakiCookieSeti) {
            System.out.println(siraNo + ". cookie: " + eachCookie);
            siraNo++;
        }

        // Ve silindigini test edin.
        boolean socsVarMi = false;

        for (Cookie eachCookie : sayfadakiCookieSeti) {
            if (eachCookie.getName().equalsIgnoreCase("SOCS")) {
                socsVarMi = true;
            }
        }

        /*
                Tum cookie'lerin isimlerini kontrol ettik.
                Ismi SOCS olan varsa socsVarMi= true,
                ismi SOCS olan yoksa socsVarMi= false, olacak.
         */

        Assertions.assertFalse(socsVarMi);

        // Tum cookie'leri silin.
        driver.manage().deleteAllCookies();

        // Ve silindigini test edin.
        sayfadakiCookieSeti = driver.manage().getCookies();
        Assertions.assertEquals(0, sayfadakiCookieSeti.size());
        ReusableMethods.wait(1);
    }
}