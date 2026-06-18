package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q04 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://demoqa.com/droppable adresine gidelim.
        driver.get("https://demoqa.com/droppable");

        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim.
        WebElement dragMeButton = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereBox = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        ReusableMethods.wait(2);
        actions.dragAndDrop(dragMeButton, dropHereBox)
                .perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin.
        String expectedText = "Dropped!";
        String actualText = dropHereBox.getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}