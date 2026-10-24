package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin.
        WebElement carpintiCheckBox = driver.findElement(By.xpath("//input[@id='gridCheck4']"));
        WebElement sirtAgrisiCheckBox = driver.findElement(By.xpath("//input[@id='gridCheck5']"));
        carpintiCheckBox.click();
        sirtAgrisiCheckBox.click();

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin.
        Assertions.assertTrue(carpintiCheckBox.isSelected());
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin.
        WebElement sekerCheckBox = driver.findElement(By.xpath("//input[@id='hastalikCheck2']"));
        WebElement epilepsiCheckBox = driver.findElement(By.xpath("//input[@id='hastalikCheck7']"));
        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());
    }
}