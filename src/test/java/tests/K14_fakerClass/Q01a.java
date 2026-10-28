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

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com adresine gidelim.
        driver.get("https://www.testotomasyonu.com");

        // 2- Account linkine tiklayin.
        driver.findElement(By.xpath("//a[@class='e-cart']"))
                .click();

        // 3- Sign Up linkine basalim.
        driver.findElement(By.xpath("//*[.=' Sign Up']"))
                .click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim.
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);
        actions.click(firstNameBox)
                .sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(surname)
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
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        ReusableMethods.wait(2);
        actions.click(emailBox)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        driver.findElement(By.xpath("//button[@id='submitlogin']"))
                .click();
        WebElement myProfileLink = driver.findElement(By.xpath("//*[.='My Profile']"));
        Assertions.assertTrue(myProfileLink.isDisplayed());
    }
}