package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q03a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin.
        // 2- https://www.testotomasyonu.com/ adresine gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 3- Arama kutusuna phone yazip aratin.
        WebElement aramaKutusuElementi = driver.findElement(By.xpath("//input[@id='global-search']"));
        aramaKutusuElementi.sendKeys("phone" + Keys.ENTER);

        // 4- Category bolumunde 8 element oldugunu test edin.
        List<WebElement> kategoriElementleriList = driver.findElements(By.xpath("//ul[@class='panel-list']"));
        Assertions.assertEquals(8, kategoriElementleriList.size());

        // 5- Category isimlerini yazdirin.
        System.out.println(ReusableMethods.stringListeDondur(kategoriElementleriList));
    }
}