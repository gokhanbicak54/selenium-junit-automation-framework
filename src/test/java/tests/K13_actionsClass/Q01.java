package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q01 extends TestBase_Each {

    @Test
    public void test() {

        Actions actions = new Actions(driver);

        // 1- https://testotomasyonu.com/click sitesine gidin.
        driver.get("https://testotomasyonu.com/click");

        // 2- “DGI Drones” uzerinde sag click yapin.
        WebElement dronesElementi = driver.findElement(By.xpath("//img[@id='pic2_thumb']"));
        ReusableMethods.wait(2);
        actions.contextClick(dronesElementi)
                .perform();

        // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedText = "Tebrikler!... Sağ click yaptınız.";
        String actualText = driver.switchTo()
                .alert()
                .getText();
        Assertions.assertEquals(expectedText, actualText);

        // 4- Tamam diyerek alert’i kapatalim.
        driver.switchTo()
                .alert()
                .accept();
    }
}