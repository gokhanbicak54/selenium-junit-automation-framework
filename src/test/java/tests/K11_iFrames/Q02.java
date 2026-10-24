package tests.K11_iFrames;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class Q02 extends TestBase_Each {

    @Test
    public void test01() {

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz.
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) Cookies kabul edin.
        // 3) Sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki toplam iframe sayısı: " + iframes.size()); // 2

        // 4) Ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame1);

        WebElement youtubePlayIcon = driver.findElement(By.xpath("(//span[@class='yt-icon-shape ytSpecIconShapeHost'])[1]"));
        youtubePlayIcon.click();

        // 5) Ilk iframe'den çıkıp ana sayfaya dönünüz.
        driver.switchTo().defaultContent();

        // 6) Ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tiklayiniz.
        WebElement iFrame2 = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iFrame2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']"))
                .click();
    }
}