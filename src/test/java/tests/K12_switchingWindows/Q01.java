package tests.K12_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q01 extends TestBase_Each {

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
        ReusableMethods.titleIleWindowGecisYap(driver, "New Window");
        System.out.println(driver.getTitle());

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedNewText = "New Window";
        String actualNewText = driver.getTitle();
        Assertions.assertEquals(expectedNewText, actualNewText);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin.
        ReusableMethods.titleIleWindowGecisYap(driver, "The Internet");

        // expectedTitle = "The Internet";
        // actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}