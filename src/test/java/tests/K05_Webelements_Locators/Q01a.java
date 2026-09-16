package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin.
        // 2- https://www.testotomasyonu.com adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        // 3- Urun arama kutusunu locate edin.
        WebElement aramaKutusuElementi = driver.findElement(By.xpath("//input[@id='global-search']"));

        // 4- Arama kutusuna “shoe” yazdirin.
        aramaKutusuElementi.sendKeys("shoe");

        // 5- Arama islemini yapabilmek icin ENTER tusuna basin.
        aramaKutusuElementi.submit();
    }
}