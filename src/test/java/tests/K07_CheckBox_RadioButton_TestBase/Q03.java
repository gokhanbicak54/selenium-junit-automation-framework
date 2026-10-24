package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q03 extends TestBase_Each {

    @Test
    public void radioButton() {

        // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin.
        WebElement kadinRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        WebElement digerRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio3']"));

        // c. Iki farkli test method’u oluşturup yazidan veya direkt buton’dan size uygun olani secin.
        erkekRadioButton.click();

        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin.
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}