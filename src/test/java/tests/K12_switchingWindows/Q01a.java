package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // Yeni bir class olusturun: WindowHandle
        // testotomasyonu anasayfa adresine gidin.
        driver.get("https://testotomasyonu.com/");

        // Sayfa’nin window handle degerini String bir degiskene atayin.
        String testOtomasyonuWhd = driver.getWindowHandle();

        // Sayfa title’nin “Otomasyon” icerdigini test edin.
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // Sayfa title’nin “Wise Quarter” icerdigini test edin.
        expectedTitleIcerik = "Wise Quarter";
        actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        // Sayfa title’nin “Walmart” icerdigini test edin.
        expectedTitleIcerik = "Walmart";
        actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Ilk acilan window’a donun ve testotomasyonu sayfasina dondugunuzu test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/");
        String expectedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}