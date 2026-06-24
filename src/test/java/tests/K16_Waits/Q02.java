package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q02 {

    @Test
    public void implicitWait() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']"))
                .click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itsGoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assertions.assertTrue(itsGoneElement.isDisplayed());

        // 4. Add buttonuna basin.
        driver.findElement(By.xpath("//button[.='Add']"))
                .click();

        // 5. It’s back mesajinin gorundugunu test edin.
        WebElement itsBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.=\"It's back!\"]")));
        Assertions.assertTrue(itsBackElement.isDisplayed());
        driver.quit();
    }
}