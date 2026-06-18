package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q05 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://www.testotomasyonu.com/ adresine gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin.
        WebElement kidsWearMenu = driver.findElement(By.xpath("(//a[.='Kids Wear'])[3]"));
        ReusableMethods.wait(2);
        actions.moveToElement(kidsWearMenu)
                .perform();

        // 3- “Boys” linkine basin.
        driver.findElement(By.xpath("//a[.='Boys']"))
                .click();

        // 4- Acilan sayfadaki ilk urunu tiklayin.
        driver.findElement(By.xpath("//img[@class='lazy']"))
                .click();

        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin.
        WebElement urunelementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = urunelementi.getText();
        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);
    }
}