package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q04a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin.
        // 2- https://www.automationexercise.com/ adresine gidin.
        driver.get("https://www.automationexercise.com/");

        // 3- Category bolumundeki elementleri locate edin.
        List<WebElement> kategoriElementleriList = driver.findElements(By.xpath("//div[@class='panel-heading']"));

        // 4- Category bolumunde 3 element oldugunu test edin.
        Assertions.assertEquals(3, kategoriElementleriList.size());

        // 5- Category isimlerini yazdirin.
        System.out.println(ReusableMethods.stringListeDondur(kategoriElementleriList));
    }
}