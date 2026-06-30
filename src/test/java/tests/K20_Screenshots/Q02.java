package tests.K20_Screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02 extends TestBase_Each {

    @Test
    public void test01() {

        // 1- testotomasyonu anasayfaya gidin.
        driver.get("https://testotomasyonu.com/");

        // 2- phone icin arama yapin.
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search']"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // 3- Arama sonucunda urun bulunabildigini test edin.
        WebElement aramaSonuc = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String expectedAramaSonuc = "4 Products Found";
        String actualAramaSonuc = aramaSonuc.getText();
        Assertions.assertEquals(expectedAramaSonuc, actualAramaSonuc);

        WebElement accountElement = driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"));
        Assertions.assertTrue(accountElement.isDisplayed());

        // 4- Arama sonuc elementinin fotografini cekip, jpeg olarak kaydedin.
        ReusableMethods.tumSayfaResimCek(driver, "rapor1");
        ReusableMethods.webElementResimCek(accountElement, "rapor webelement");
        ReusableMethods.tarihliTumSayfaResimCek(driver);
    }
}