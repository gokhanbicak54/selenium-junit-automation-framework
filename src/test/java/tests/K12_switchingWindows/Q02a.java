package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingTextElementi = driver.findElement(By.xpath("//*[.='Opening a new window']"));
        String expectedText = "Opening a new window";
        String actualText = openingTextElementi.getText();
        Assertions.assertEquals(expectedText, actualText);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://the-internet.herokuapp.com/windows/new");
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowTextElementi = driver.findElement(By.xpath("(//*[.='New Window'])[2]"));
        expectedText = "New Window";
        actualText = newWindowTextElementi.getText();
        Assertions.assertEquals(expectedText, actualText);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin.
        ReusableMethods.urlIleWindowGecisYap(driver, "https://the-internet.herokuapp.com/windows");
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}