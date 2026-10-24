package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q04a_ extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);
        // a. Verilen web sayfasına gidin. https://facebook.com
        driver.get("https://facebook.com");

        // b. Cookies’i kabul edin.
        // c. Create an account buton’una basin.
        ReusableMethods.wait(2);

        WebElement accountButton = driver.findElement(By.xpath("(//div[@role='none'])[9]"));
        actions.click(accountButton).perform();

        // d. Radio button elementlerini locate edin ve size uygun olani secin.
        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin.
    }
}