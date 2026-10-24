package tests.K11_iFrames;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz.
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) Cookies kabul edin.
        // 3) Sayfadaki iframe sayisini bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi: " + iframes.size());

        // 4) Ilk iframe'deki (Youtube) play butonuna tiklayiniz.
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe1);
        driver.findElement(By.xpath("//button[@title='Videoyu oynat']"))
                .click();
        ReusableMethods.wait(2);

        // 5) Ilk iframe'den cikip ana sayfaya donunuz.
        driver.switchTo().defaultContent();
        ReusableMethods.wait(2);

        // 6) Ikinci iframe'deki (Jmeter Made Easy) linke tiklayiniz. (https://www.guru99.com/live-selenium-project.html)
        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", iframe2);
        ReusableMethods.wait(2);
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']"))
                        .click();
        ReusableMethods.wait(2);
    }
}