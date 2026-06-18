package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q08 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://www.testotomasyonu.com adresine gidelim.
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin.
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"))
                .click();

        // 3- Sign Up linkine basalim.
        driver.findElement(By.xpath("//a[@class='sign-up ']"))
                .click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim.
        WebElement nameInputBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        ReusableMethods.wait(2);
        actions.click(nameInputBox)
                .sendKeys("Gokhan")
                .sendKeys(Keys.TAB)
                .sendKeys("Bicak")
                .sendKeys(Keys.TAB)
                .sendKeys("sakarya@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("EdinDjeko")
                .sendKeys(Keys.TAB)
                .sendKeys("EdinDjeko")
                .perform();
        driver.findElement(By.xpath("//button[@id='btn-submit-form']"))
                .click();

        // 5- Kaydin olusturuldugunu test edin.
        WebElement mailInputBox = driver.findElement(By.xpath("//input[@id='email']"));
        ReusableMethods.wait(2);
        actions.click(mailInputBox)
                .sendKeys("sakarya@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("EdinDjeko")
                .perform();
        driver.findElement(By.xpath("//button[@id='submitlogin']"))
                .click();
        WebElement logoutElementi = driver.findElement(By.xpath("(//span[@class='item'])[6]"));
        Assertions.assertTrue(logoutElementi.isEnabled());
    }
}