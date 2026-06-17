package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03 extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/discount adresine gidin.
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur olduğunu test edin.
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);

        WebElement elektronicsProductsYaziElementi = driver.findElement(By.xpath("//h2[.='Electronics Products']"));
        Assertions.assertTrue(elektronicsProductsYaziElementi.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin.
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.xpath("//span[.='DELL Core I3 11th Gen ']")).getText();
        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // 4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        driver.findElement(By.xpath("//span[.='DELL Core I3 11th Gen ']")).click();
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/product/58");

        String expectedFiyat = "$399.00";
        String actualFiyat = driver.findElement(By.xpath("//*[.='$399.00']")).getText();
        Assertions.assertEquals(expectedFiyat, actualFiyat);

        // 5- Ilk window’a donun ve Fashion yazisinin gorunur olduğunu test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://testotomasyonu.com/discount");

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[.='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());
    }
}