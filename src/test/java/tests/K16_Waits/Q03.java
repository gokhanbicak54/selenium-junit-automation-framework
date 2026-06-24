package tests.K16_Waits;

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

        // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin.
        driver.get("http://webdriveruniversity.com/Actions");

        // 2. "Hover over Me First" kutusunun ustune gelin.
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        ReusableMethods.wait(2);
        actions.moveToElement(hoverOverMeFirst).perform();

        // 3. "Link 1" e tiklayin.
        driver.findElement(By.xpath("(//a[.='Link 1'])[1]"))
                .click();

        // 4. Popup mesajini yazdirin.
        System.out.println(driver.switchTo().alert().getText());

        // 5. Popup'i tamam diyerek kapatin.
        driver.switchTo().alert().accept();

        // 6. "Click and hold" kutusuna basili tutun.
        WebElement clickAndHold = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        ReusableMethods.wait(2);
        actions.clickAndHold(clickAndHold).perform();

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin.
        System.out.println(clickAndHold.getText());

        // 8. "Double click me" butonunu cift tiklayin.
        WebElement doubleClickMe = driver.findElement(By.xpath("//h2[.='Double Click Me!']"));
        ReusableMethods.wait(2);
        actions.doubleClick(doubleClickMe).perform();
    }
}