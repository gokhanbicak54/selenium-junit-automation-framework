package tests.K13_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q06 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin.
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin.
        WebElement hoverOverMeFirstBox = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        ReusableMethods.wait(2);
        actions.moveToElement(hoverOverMeFirstBox)
                .perform();

        // 3- Link 1" e tiklayin.
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"))
                .click();

        // 4- Popup mesajini yazdirin.
        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin.
        driver.switchTo()
                .alert()
                .accept();

        // 6- “Click and hold" kutusuna basili tutun.
        WebElement clickAndHoldBox = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        ReusableMethods.wait(2);
        actions.clickAndHold(clickAndHoldBox)
                .perform();

        // 7- “Click and hold" kutusunda cikan yaziyi yazdirin.
        System.out.println(clickAndHoldBox.getText());

        // 8- “Double click me" butonunu cift tiklayin.
        WebElement doubleClickMeButton = driver.findElement(By.xpath("//div[@id='double-click']"));
        ReusableMethods.wait(2);
        actions.doubleClick(doubleClickMeButton)
                .perform();
    }
}