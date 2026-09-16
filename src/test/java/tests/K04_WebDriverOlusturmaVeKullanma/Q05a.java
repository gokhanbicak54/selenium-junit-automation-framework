package tests.K04_WebDriverOlusturmaVeKullanma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q05a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. Yeni bir class olusturun.
        // 2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        // doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com/");

        // 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 4. Daha sonra testotomasyonu sayfasina gidin. https://www.testotomasyonu.com/
        driver.navigate().to("https://www.testotomasyonu.com/");

        // 5. Youtube sayfasina geri donun.
        driver.navigate().back();

        // 6. Sayfayi yenileyin.
        driver.navigate().refresh();

        // 7. Testotomasyonu sayfasina donun.
        ReusableMethods.wait(2);
        driver.navigate().forward();

        // 8. Sayfayi tamsayfa yapin.
        ReusableMethods.wait(2);
        driver.manage().window().fullscreen();

        // 9. Ardından sayfa başlığının "Test" içerip içermediğini (contains) test edin, Yoksa doğru başlığı(Actual Title) yazdirin.
        String expectedTitleIcerik = "Test";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 10. Sayfa URL'sinin https://www.testotomasyonu.com/ olup olmadığını test edin, degilse doğru URL'yi yazdirin.
        String expectedTOUrl = "https://www.testotomasyonu.com/";
        String actualTOUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedTOUrl, actualTOUrl);
    }
}