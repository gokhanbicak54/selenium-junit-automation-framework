package tests.K04_WebDriverOlusturmaVeKullanma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. Youtube ana sayfasina gidin. https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // 2. Url’in “youtube” icerdigini test edin.
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 3. Testotomasyonu sayfasina gidin. https://www.testotomasyonu.com/
        driver.navigate().to("https://www.testotomasyonu.com/");

        // 4. Title’in “Test Otomasyonu” icerdigini test edin.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 5. Tekrar YouTube sayfasina donun.
        driver.navigate().back();

        // 6. Title’in “YouTube” oldugunu test edin.
        String expectedYoutubeTitle = "YouTube";
        String actualYoutubeTitle = driver.getTitle();
        Assertions.assertEquals(expectedYoutubeTitle, actualYoutubeTitle);

        // 7. Sayfayi Refresh(yenile) yapin.
        driver.navigate().refresh();
    }
}