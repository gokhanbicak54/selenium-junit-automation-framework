package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q05 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1."http://webdriveruniversity.com/" adresine gidin.
        driver.get("http://webdriveruniversity.com/");
        System.out.println(driver.getCurrentUrl());

        // 2."Login Portal" a  kadar asagi inin.
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 3."Login Portal" a tiklayin.
        ReusableMethods.wait(2);
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']"))
                .click();

        // 4.Diger window'a gecin.
        ReusableMethods.urlIleWindowGecisYap(driver, "http://webdriveruniversity.com/Login-Portal/index.html");

        // 5."username" ve "password" kutularina deger yazdirin.
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        ReusableMethods.wait(2);
        actions.click(usernameBox)
                .sendKeys("gokhan")
                .sendKeys(Keys.TAB)
                .sendKeys("bicak")
                .perform();

        // 6."login" butonuna basin.
        driver.findElement(By.xpath("//button[.='Login']"))
                .click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin.
        String expectedAlertText = "validation failed";
        String actualAlertText = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // 8.Ok diyerek Popup'i kapatin.
        driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun.
        ReusableMethods.wait(2);
        ReusableMethods.urlIleWindowGecisYap(driver, "https://webdriveruniversity.com/");

        // 10.Ilk sayfaya donuldugunu test edin.
        ReusableMethods.wait(2);
        String expectedUrl = "https://webdriveruniversity.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}