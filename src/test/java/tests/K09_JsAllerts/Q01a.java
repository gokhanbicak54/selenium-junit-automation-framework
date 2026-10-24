package tests.K09_JsAllerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // - https://testotomasyonu.com/javascriptAlert adresine gidin.
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 1.alert'e tiklayin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
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
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin.
        driver.switchTo().alert().dismiss();
        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.xpath("//*[.='You clicked: Cancel']")).getText();
        Assertions.assertEquals(expectedResultText, actualResultText);
    }

    @Test
    public void test03() {

        // - https://testotomasyonu.com/javascriptAlert adresine gidin.
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert'e tiklayalim.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();

        // - Cikan prompt ekranina "YTU Oryantiring" yazdiralim.
        driver.switchTo().alert().sendKeys("YTU Oryantiring");

        // - OK tusuna basarak alert'i kapatalim.
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin "Oryantiring" icerdigini test edelim.
        String expectedResultContent = "Oryantiring";
        String actualResultText = driver.findElement(By.xpath("//*[.='You entered: YTU Oryantiring']")).getText();
        Assertions.assertTrue(actualResultText.contains(expectedResultContent));
    }
}