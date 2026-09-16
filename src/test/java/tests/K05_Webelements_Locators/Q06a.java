package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class Q06a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin.
        // 2- https://www.automationexercise.com/ adresine gidin.
        driver.get("https://www.automationexercise.com/");

        // 3- Sayfada 150 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));
        Assertions.assertEquals(150, linkElementleriList.size());

        // 4- Products linkine tiklayin.
        driver.findElement(By.xpath("//*[text()=' Products']"))
                .click();

        // 5- special offer yazisinin gorundugunu test edin.
        WebElement specialOfferYazisi = driver.findElement(By.xpath("//img[@id='sale_image']"));
        Assertions.assertTrue(specialOfferYazisi.isDisplayed());
    }
}