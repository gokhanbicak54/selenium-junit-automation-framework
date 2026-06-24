package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class Q01 {

    // Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.

    WebDriver driver;

    @Test
    public void implicitWaitTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin.
        driver.findElement(By.xpath("(//button[@type='button'])[2]"))
                .click();
        ReusableMethods.wait(3);

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement mesajText = driver.findElement(By.xpath("//p[@id='message']"));
        Assertions.assertTrue(mesajText.isDisplayed());
        driver.quit();
    }

    @Test
    public void explicitWaitTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayın.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin.
        driver.findElement(By.xpath("(//button[@type='button'])[2]"))
                .click();

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement mesajText = driver.findElement(By.xpath("//p[@id='message']"));
        Assertions.assertTrue(mesajText.isDisplayed());
        driver.quit();
    }
}