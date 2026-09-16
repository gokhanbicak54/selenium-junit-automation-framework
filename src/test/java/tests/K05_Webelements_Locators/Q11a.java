package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q11a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. http://zero.webappsecurity.com sayfasina gidin.
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin.
        driver.findElement(By.xpath("//button[@id='signin_button']"))
                .click();

        // 3. Login alanina “username” yazdirin.
        WebElement loginKutusu = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

        // 4. Password alanina “password” yazdirin.
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");

        // 5. Sign in buttonuna tiklayin.
        driver.findElement(By.xpath("//input[@class='btn btn-primary']"))
                .click();

        // 6. Back tusu ile sayfaya donun.
        ReusableMethods.wait(2);
        driver.navigate().back();

        // 7. Online Banking menusunden Pay Bills sayfasina gidin.
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]"))
                .click();
        driver.findElement(By.xpath("//span[.='Pay Bills']"))
                .click();

        // 8. amount kismina yatirmak istediginiz herhangi bir miktari yazin.
        WebElement amountKutusu = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountKutusu.sendKeys("54");

        // 9. Tarih kismina “2023-09-10” yazdirin.
        WebElement dateKutusu = driver.findElement(By.xpath("//input[@id='sp_date']"));
        dateKutusu.sendKeys("2023-09-10");

        // 10. Pay buttonuna tiklayin.
        driver.findElement(By.xpath("//input[@class='btn btn-primary']"))
                .click();

        // 11. “The payment was successfully submitted.” mesajinin ciktigini test edin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String expectedSonucYazisi = "The payment was successfully submitted.";
        String actualSonucYazisi = sonucYazisi.getText();
        Assertions.assertEquals(expectedSonucYazisi, actualSonucYazisi);
    }
}