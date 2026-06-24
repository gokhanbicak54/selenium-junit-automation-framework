package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q04 extends TestBase_Each {

    @Test
    public void test01() {

        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin.
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2. “Our Products” butonuna basin.
        WebElement ourProductsIFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(ourProductsIFrame);
        driver.findElement(By.xpath("//a[.='Our Products']"))
                .click();

        // 3. “Cameras product”i tiklayin.
        ReusableMethods.wait(2);
        driver.findElement(By.xpath("//p[.='Cameras']"))
                .click();

        // 4. Popup mesajini yazdirin.
        ReusableMethods.wait(2);
        WebElement popupElement = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        System.out.println(popupElement.getText());

        // 5. “close” butonuna basin.
        ReusableMethods.wait(2);
        driver.findElement(By.xpath("//button[.='Close']")).click();

        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin.
        ReusableMethods.wait(2);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[.='WebdriverUniversity.com (IFrame)']"))
                .click();

        // 7. "https://webdriveruniversity.com/index.html" adresine gittigini test edin.
        ReusableMethods.wait(2);
        String expectedUrl = "https://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}