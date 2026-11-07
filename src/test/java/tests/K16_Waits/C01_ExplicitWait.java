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

public class C01_ExplicitWait {

    // Iki tane method olusturun: implicitWaitTest, explicitWaitTest
    // Iki method icin de asagidaki adimlari test edin.

    WebDriver driver;

    @Test
    public void implicitWaitTesti() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tiklayin.
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();

        // Ve textbox etkin oluncaya kadar bekleyin.
        ReusableMethods.wait(3);

        /*
         Testimiz implicitlyWaitTest oldugu icin implicitly wait'in yeterli olup olmadigini kontrol edip yeterli olmazsa ekstra bekleme koymak gerekir.
         */

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayin.
        Assertions.assertTrue(textBox.isEnabled());

        /*
            implicitlyWait() iki durumda bekleme yapar.
            1- Sayfanin yuklenmesi.
            2- Bir webelement'in locate edilmesi icin.

            Gorevin 4.maddesinde textbox'in etkin olmasini beklememiz gerekiyor.
            Ancak bu bekleme implicitlyWait()'in gorev kapsaminda yok.
            Bu sebeple implicitlyWait() ile yaptigimizda 4.gorev FAILED olacaktir.
            Testin passed olmasi icin mutlaka ekstra bekleme gerekir.
            4.gorevin gerceklesmesi icin Thread.sleep() kullandik.
         */

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        /*
            4.gorevde implicitly wait bekleme yapmadi. ANCAAAKKK
            5.gorevde gorunmeyen elementin gorunur olmasini ve locate edilebilmesini beklemek gerekiyor.
            Bu da implicitlyWait()'in gorev alanina girer.
            Yaniii ozetle implicitlyWait() 4.gorevi gerceklestirmemizi saglayamazken, 5.gorev icin yeterli olur.
         */

        ReusableMethods.wait(2);
        driver.quit();
    }

    @Test
    public void explicitWaitTesti() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Textbox’in etkin olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        // 3. Enable butonuna tiklayin.
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();

        // Ve textbox etkin oluncaya kadar bekleyin.
        // explicitlyWait ile bekleyelim.

            // 1.adim bir wait objesi olustur.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 2.adim MUMKUNSE beklenecek objeyi locate edip bir webelement olarak kaydedin.
            //        textbox'i locate edebiliyoruz ve yukarida locate edip kaydettik.

            // 3.adim wait objesine neyi bekleyecegini soyleyin.
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        // 4. Textbox’in etkin oldugunu(enabled) dogrulayin.
        Assertions.assertTrue(textBox.isEnabled());

        // 5. “It’s enabled!” mesajinin goruntulendigini dogrulayin.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());
        driver.quit();
    }
}