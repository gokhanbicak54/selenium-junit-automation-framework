package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://testotomasyonu.com/droppable adresine gidelim.
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim.
        WebElement acceptableButton = driver.findElement(By.xpath("//div[@id='draggable2']"));
        WebElement dropHereKutusu = driver.findElement(By.xpath("//div[@id='droppable2']"));
        ReusableMethods.wait(2);
        actions.dragAndDrop(acceptableButton, dropHereKutusu)
                .perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin.
        String expectedYazi = "Dropped!";
        String actualYazi = dropHereKutusu.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);

        // 4- Sayfayi yenileyin.
        driver.navigate().refresh();

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim.
        WebElement notAcceptableButton = driver.findElement(By.xpath("//div[@id='draggable-nonvalid2']"));
        dropHereKutusu = driver.findElement(By.xpath("//div[@id='droppable2']"));
        ReusableMethods.wait(2);
        actions.dragAndDrop(notAcceptableButton, dropHereKutusu)
                .perform();

        // 6- “Drop Here” yazisinin degismedigini test edin.
        expectedYazi = "Drop Here";
        actualYazi = dropHereKutusu.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}