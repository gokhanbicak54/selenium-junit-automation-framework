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

public class Q01a {

    // Iki tane metod olusturun: implicitWaitTest, explicitWaitTest
    // Iki metod icin de asagidaki adimlari test edin.

    WebDriver driver;

    @Test
    public void implicitWaitTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin.
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();
        ReusableMethods.wait(3); // Aktiflik için en az 3 sn beklemek gerekiyor.

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(sonucYazisi.isDisplayed());
        driver.quit();
    }

    @Test
    public void explicitWaitTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin.
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(sonucYazisi.isDisplayed());
        driver.quit();
    }
}