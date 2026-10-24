package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() {

        // https://testotomasyonu.com/javascriptAlert adresine gidin.
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 1.alert'e tiklayin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']"))
                .click();

        // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin.
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertText, actualAlertText);

        // - OK tusuna basip alert'i kapatin.
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {

        // - https://testotomasyonu.com/javascriptAlert adresine gidin.
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 2.alert'e tiklayalim.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
                .click();

        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin.
        driver.switchTo().alert().dismiss();

        String expectedSonucText = "You clicked: Cancel";
        String actualSonucText = driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        Assertions.assertEquals(expectedSonucText, actualSonucText);
    }

    @Test
    public void test03() {

        // - https://testotomasyonu.com/javascriptAlert adresine gidin.
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"))
                .click();

        // - Cikan prompt ekranina "Abdullah" yazdiralim.
        driver.switchTo().alert().sendKeys("Abdullah");

        // - OK tusuna basarak alert'i kapatalim.
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim.
        String expectedSonucText = "Abdullah";
        String actualSonucText = driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        Assertions.assertTrue(actualSonucText.contains(expectedSonucText));
    }
}