package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03a extends TestBase_Each {

    @Test
    public void test01() {

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // Sayfadaki textin “Add/Remove Elements” oldugunu dogrulayin.
        WebElement addRemoveTextElementi = driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));
        String expectedText = "Add/Remove Elements";
        String actualText = addRemoveTextElementi.getText();
        Assertions.assertEquals(expectedText, actualText);

        // Sayfa başlığının(title) “Test Otomasyonu” icerdigini dogrulayin.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // ’Please click for Electronics Products linkine tiklayin.
        driver.findElement(By.xpath("//*[.='Electronics Products']"))
                .click();

        // Electronics sayfasinin acildigini test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/category/7/products");
        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);

        // Bulunan urun sayisinin 16 oldugunu test edin.
        WebElement urunSayisiSonucElementi = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String urunSayisiSonucStr = urunSayisiSonucElementi.getText();
        urunSayisiSonucStr = urunSayisiSonucStr.replaceAll("\\D", "");
        int urunSayisiSonucInt = Integer.parseInt(urunSayisiSonucStr);
        Assertions.assertEquals(urunSayisiSonucInt, 16);

        // Ilk actiginiz addremove sayfasinin oldugu window’a donun.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/addremove/");

        // Url’in addremove icerdigini test edin.
        String expectedUrlIcerik = "addremove";
        actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}