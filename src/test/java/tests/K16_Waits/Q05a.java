package tests.K16_Waits;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q05a extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        // 1."http://webdriveruniversity.com/" adresine gidin.
        driver.get("http://webdriveruniversity.com/");

        // 2."Login Portal" a kadar asagi inin.
        WebElement loginPortal = driver.findElement(By.xpath("//*[.='LOGIN PORTAL']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", loginPortal);

        // 3."Login Portal" a tiklayin.
        actions.click(loginPortal)
                .perform();

        // 4.Diger window'a gecin.
        ReusableMethods.urlIleWindowGecisYap(driver, "http://webdriveruniversity.com/Login-Portal/index.html");

        // 5."username" ve "password" kutularina deger yazdirin.
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='text']"));
        // WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        String username = faker.name().username();
        String password = faker.internet().password();
        actions.click(usernameBox)
                .sendKeys(username)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();

        // 6."login" butonuna basin.
        driver.findElement(By.xpath("//button[@id='login-button']"))
                .click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin.
        String expectedAlertText = "validation failed";
        String actualAlertText = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // 8.Ok diyerek Popup'i kapatin.
        driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://webdriveruniversity.com/");

        // 10.Ilk sayfaya donuldugunu test edin.
        String expectedUrl = "https://webdriveruniversity.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}