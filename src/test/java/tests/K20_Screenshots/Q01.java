package tests.K20_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() throws IOException {

        // 1- testotomasyonu anasayfaya gidin.
        driver.get("https://testotomasyonu.com/");

        // 2- Nutella icin arama yapin.
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search']"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // 3- Arama sonucunda urun bulunamadigini test edin.
        WebElement aramaSonuc = driver.findElement(By.xpath("//*[.='0 Products Found']"));
        String expectedAramaSonuc = "0 Products Found";
        String actualAramaSonuc = aramaSonuc.getText();
        Assertions.assertEquals(expectedAramaSonuc, actualAramaSonuc);

        // 4- Arama sonuc sayfasinin fotografini cekip, jpeg olarak kaydedin.
        ReusableMethods.wait(2);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String dosyaYolu = "target/screenshots/tumSayfaResmi.jpeg";
        File tumSayfaSS = new File(dosyaYolu);
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaSS);

        ReusableMethods.tumSayfaResimCek(driver, "rapor1");
    }
}