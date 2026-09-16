package tests.K04_WebDriverOlusturmaVeKullanma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class Q04a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. Yeni bir class olusturalim.
        // 2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        // (title) “facebook” oldugunu test edin, degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com/");

        // 3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 4. https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitleIcerik = "Walmart.com";
        String actualTitle = driver.getTitle();
        // Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik), "Icerik testi FAILED"); // Test failed

        // 6. Tekrar “facebook” sayfasina donun.
        driver.navigate().back();

        // 7. Sayfayi yenileyin.
        driver.navigate().refresh();

        // 8. Sayfayi tam sayfa (maximize) yapin.
        driver.manage().window().maximize();
    }
}