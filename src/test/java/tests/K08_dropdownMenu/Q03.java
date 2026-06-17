package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03 extends TestBase_Each {

    @Test
    public void test01() {
        // 1. http://zero.webappsecurity.com/ adresine gidin.
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin.
        driver.findElement(By.xpath("//i[@class='icon-signin']"))
                .click();

        // 3. Login kutusuna “username” yazin.
        driver.findElement(By.xpath("//input[@id='user_login']"))
                .sendKeys("username");

        // 4. Password kutusuna “password” yazin.
        driver.findElement(By.xpath("//input[@id='user_password']"))
                .sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun.
        driver.findElement(By.xpath("//input[@type='submit']"))
                .click();
        ReusableMethods.wait(2);
        driver.navigate().back();
        ReusableMethods.wait(2);

        // 6. Online banking menusunden Pay Bills sayfasina gidin.
        driver.findElement(By.xpath("//strong[.='Online Banking']"))
                .click();
        driver.findElement(By.xpath("//span[.='Pay Bills']"))
                .click();

        // 7. “Purchase Foreign Currency” tusuna basin.
        driver.findElement(By.xpath("//a[.='Purchase Foreign Currency']"))
                .click();

        // 8. “Currency” drop down menusunden Eurozone’u secin.
        WebElement ddmCurrency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddmCurrency);
        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin.
        driver.findElement(By.xpath("//input[@id='pc_amount']"))
                .sendKeys("100");

        // 10. “US Dollars” in secilmedigini test edin.
        WebElement usDollarsRadioButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assertions.assertFalse(usDollarsRadioButton.isSelected());

        // 11. “Selected currency” butonunu secin.
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']"))
                .click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin.
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']"))
                .click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']"))
                .click();

        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYazısı = driver.findElement(By.xpath("//div[.='Foreign currency cash was successfully purchased.']"));
        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = sonucYazısı.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}