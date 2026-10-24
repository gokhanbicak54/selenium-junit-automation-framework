package tests.K11_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01 extends TestBase_Each {

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

        // 4- ‘Here are some products’ yazisinin gorunur olduğunu test edin.
        driver.switchTo().defaultContent();
        WebElement hereAreSomeProductsYazisi = driver.findElement(By.xpath("//p[.='Here are some products.']"));
        Assertions.assertTrue(hereAreSomeProductsYazisi.isDisplayed());

        // 5- ‘Fashion’ yazisinin gorunur olduğunu test edin.
        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        // 6- Fashion bolumundeki ilk urunu tiklayin ve ilk urun isminde "Men Slim Fit" gectigini test edin.
        WebElement ilkUrunElementi = driver.findElement(By.xpath("//p[.='Men Slim Fit Casual Shirt']"));
        String expectedUrunTitleIcerik = "Men Slim Fit";
        String actualUrunTitle = ilkUrunElementi.getText();
        Assertions.assertTrue(actualUrunTitle.contains(expectedUrunTitleIcerik));
        ilkUrunElementi.click();
    }
}