package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03a extends TestBase_Each {

    @Test
    public void test01() {

        // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini yazidan locate edin.
        WebElement kadinRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        WebElement digerRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio3']"));

        // c. Test method’u oluşturup yazidan size uygun olani secin.
        erkekRadioButton.click();
        ReusableMethods.wait(2);

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin.
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }

    @Test
    public void test02() {

        // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini butondan locate edin.
        WebElement kadinRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        WebElement digerRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio3']"));

        // c. Test method’u oluşturup butondan size uygun olani secin.
        erkekRadioButton.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin.
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}