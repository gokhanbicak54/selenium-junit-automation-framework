package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q05a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com/ adresine gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin.
        WebElement kidsWearTextLink = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);
        actions.moveToElement(kidsWearTextLink)
                .perform();

        // 3- “Boys” linkine basin.
        driver.findElement(By.xpath("//a[.='Boys']"))
                .click();

        // 4- Acilan sayfadaki ilk urunu tiklayin.
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]"))
                .click();

        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin.
        WebElement urunIsmi = driver.findElement(By.xpath("//*[.='Boys Shirt White Color']"));
        String expectedUrunIsim = "Boys Shirt White Color";
        String actualUrunIsim = urunIsmi.getText();
        Assertions.assertEquals(expectedUrunIsim, actualUrunIsim);
    }
}