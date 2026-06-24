package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        // 1- https://www.testotomasyonu.com adresine gidelim.
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin.
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]"))
                .click();

        // 3- Sign Up linkine basalim.
        driver.findElement(By.xpath("//a[@class='sign-up ']"))
                .click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim.
        WebElement nameInputBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        ReusableMethods.wait(2);
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        actions.click(nameInputBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        driver.findElement(By.xpath("//button[@id='btn-submit-form']"))
                .click();

        // 5- Kaydin olusturuldugunu test edin.
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(email);
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(password);
        driver.findElement(By.id("submitlogin")).click();
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButonu.isEnabled());
        logoutButonu.click();
    }
}