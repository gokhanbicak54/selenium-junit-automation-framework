package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q09_ extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://html.com/tags/iframe/ sayfasina gidelim.
        driver.get("https://html.com/tags/iframe/");

        // 2- Video’yu gorecek kadar asagi inin.
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();

        // 3- Video'yu izlemek icin Play tusuna basin.
        WebElement iFrameVideo = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameVideo);
        WebElement playTusu = driver.findElement(By.xpath("(//div[@style='width: 100%; height: 100%; display: block; fill: currentcolor;'])[1]"));
        ReusableMethods.wait(2);
        actions.click(playTusu).perform();
        ReusableMethods.wait(5);

        // 4- Video'yu calistirdiginizi test edin.
        /*
        WebElement videoKontrol = driver.findElement(By.xpath("(//button[@aria-label='Videoyu oynat'])[2]"));
        String icerik = videoKontrol.getAttribute("aria-label");
        Assertions.assertTrue(icerik.contains("duraklat"));
        */
    }
}