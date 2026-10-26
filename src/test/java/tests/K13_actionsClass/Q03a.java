package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/droppable adresine gidelim.
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim.
        WebElement acceptableButton = driver.findElement(By.xpath("//*[.='Acceptable']"));
        WebElement dropHereBox = driver.findElement(By.xpath("//*[.='Drop Here']"));
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);
        actions.dragAndDrop(acceptableButton, dropHereBox)
                .perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin.
        String expectedText = "Dropped!";
        String actualText = dropHereBox.getText();
        Assertions.assertEquals(expectedText, actualText);

        // 4- Sayfayi yenileyin.
        driver.navigate().refresh();

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim.
        WebElement notAcceptableButton = driver.findElement(By.xpath("//*[.='Not Acceptable']"));
        dropHereBox = driver.findElement(By.xpath("//*[.='Drop Here']"));
        actions.dragAndDrop(notAcceptableButton, dropHereBox)
                .perform();

        // 6- “Drop Here” yazisinin degismedigini test edin.
        expectedText = "Drop Here";
        actualText = dropHereBox.getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}