package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q04a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/discount adresine gidin.
        driver.get("https://testotomasyonu.com/discount");

        // 2- Electronics Products yazisinin gorunur olduğunu test edin.
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe1);
        WebElement electronicsProductsTextElementi = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsTextElementi.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ oldugunu test edin.
        WebElement dellUrun = driver.findElement(By.xpath("//*[.='DELL Core I3 11th Gen ']"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellUrun.getText();
        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // 4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        dellUrun.click();
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/product/58");
        WebElement urunFiyatElementi = driver.findElement(By.xpath("//*[.='$399.00']"));
        String expectedUrunFiyat = "$399.00";
        String actualUrunFiyat = urunFiyatElementi.getText();
        Assertions.assertEquals(expectedUrunFiyat, actualUrunFiyat);

        // 5- Ilk window’a donun ve Fashion yazisinin gorunur oldugunu test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/discount");
        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe2);
        WebElement fashionTextElementi = driver.findElement(By.xpath("//*[.='Fashion']"));
        Assertions.assertTrue(fashionTextElementi.isDisplayed());
    }
}