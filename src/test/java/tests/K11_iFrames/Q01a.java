package tests.K11_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/discount adresine gidin.
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur olduğunu test edin.
        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);
        WebElement electronicsProductsYaziElementi = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsYaziElementi.isDisplayed());

        // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin.
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[.='DELL Core I3 11th Gen ']")).getText();
        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // 4- ‘Here are some products’ yazisinin gorunur olduğunu test edin.
        driver.switchTo().defaultContent();
        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[.='Here are some products.']"));
        Assertions.assertTrue(hereAreYaziElementi.isDisplayed());

        // 5- ‘Fashion’ yazisinin gorunur olduğunu test edin.
        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);
        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[.='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        // 6- Fashion bolumundeki ilk urunu tiklayin ve ilk urun isminde "Men Slim Fit" gectigini test edin.
        driver.findElement(By.xpath("//*[.='Men Slim Fit Solid Casual Shirt']"))
                .click();
        String expectedUrunYaziIcerik = "Men Slim Fit";
        String actualUrunYazi = driver.findElement(By.xpath("(//*[.='Men Slim Fit Solid Casual Shirt'])[1]")).getText();
        Assertions.assertTrue(actualUrunYazi.contains(expectedUrunYaziIcerik));
    }
}