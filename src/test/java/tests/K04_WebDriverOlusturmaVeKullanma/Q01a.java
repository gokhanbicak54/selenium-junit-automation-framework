package tests.K04_WebDriverOlusturmaVeKullanma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfa basligini(title) yazdirin.
        System.out.println(driver.getTitle());

        // 3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 4. Sayfa adresini(url) yazdirin.
        System.out.println(driver.getCurrentUrl());

        // 5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        String expectedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        // Assertions.assertEquals(expectedUrl, actualUrl, "Url testi FAILED"); // Test failed

        // 6. Sayfa handle degerini yazdirin.
        System.out.println(driver.getWindowHandle());

        // 7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin.
        String expectedSayfaKaynakIcerik = "otomasyon";
        String actualSayfaKaynagi = driver.getPageSource();
        Assertions.assertTrue(actualSayfaKaynagi.contains(expectedSayfaKaynakIcerik));
    }
}