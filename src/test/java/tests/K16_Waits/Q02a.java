package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_Each;

import java.time.Duration;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']"))
                .click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itsGoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));
        Assertions.assertTrue(itsGoneText.isDisplayed());

        // 4. Add butonuna basin.
        driver.findElement(By.xpath("//*[.='Add']"))
                .click();

        // 5. "It’s back!" mesajinin gorundugunu test edin.
        WebElement itsBackText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));
        Assertions.assertTrue(itsBackText.isDisplayed());
    }
}