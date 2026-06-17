package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02 extends TestBase_Each {

    @Test
    public void test01() {

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addRemoveText = driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));
        String expectedText = "Add/Remove Elements";
        String actualText = addRemoveText.getText();
        Assertions.assertEquals(expectedText, actualText);

        // Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//a[.='Electronics Products']"))
                .click();

        // Electronics sayfasinin acildigini test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/category/7/products");
        String expectedNewUrl = "https://testotomasyonu.com/category/7/products";
        String actualNewUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedNewUrl, actualNewUrl);

        // Bulunan urun sayisinin 16 olduğunu test edin.
        WebElement urunSonucYazisi = driver.findElement(By.xpath("//span[.='16 Products Found']"));
        String urunSonucYazisiStr = urunSonucYazisi.getText().replaceAll("\\D", "");
        int urunSonucYazisiInt = Integer.parseInt(urunSonucYazisiStr);
        int expectedUrunSayisi = 16;
        Assertions.assertEquals(expectedUrunSayisi, urunSonucYazisiInt);

        // Ilk actiginiz addremove sayfasinin oldugu window’a donun.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/addremove/");

        // Url’in addremove icerdigini test edin.
        String expextedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expextedUrlIcerik));
    }
}