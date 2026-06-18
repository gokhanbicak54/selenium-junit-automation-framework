package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- Yeni bir class olusturalim: MouseActions1
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin.
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapin.
        WebElement cizgiliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        ReusableMethods.wait(2);
        actions.contextClick(cizgiliAlan)
                .perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo()
                .alert()
                .getText();
        Assertions.assertEquals(expectedText, actualText);

        // 5- Tamam diyerek alert’i kapatalim.
        driver.switchTo()
                .alert()
                .accept();

        // 6- Elemental Selenium linkine tiklayalim.
        driver.findElement(By.xpath("//a[@target='_blank']"))
                .click();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://elementalselenium.com/");
        WebElement elementalSeleniumYaziElementi = driver.findElement(By.xpath("//h1[.='Elemental Selenium']"));
        String expectedNewText = "Elemental Selenium";
        String actualNewText = elementalSeleniumYaziElementi.getText();
        Assertions.assertEquals(expectedNewText, actualNewText);
    }
}