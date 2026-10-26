package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Yeni bir class olusturalim: MouseActions1
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin.
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapin.
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlanElementi)
                .perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertText = "You selected a context menu";
        String actualAlertText = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // 5- Tamam diyerek alert’i kapatalim.
        driver.switchTo()
                .alert()
                .accept();

        // 6- Elemental Selenium linkine tiklayalim.
        driver.findElement(By.xpath("//*[.='Elemental Selenium']"))
                .click();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://elementalselenium.com/");
        WebElement elementalSeleniumText = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        String expectedText = "Elemental Selenium";
        String actualText = elementalSeleniumText.getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}