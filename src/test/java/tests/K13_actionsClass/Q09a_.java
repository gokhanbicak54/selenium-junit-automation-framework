package tests.K13_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q09a_ extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://html.com/tags/iframe/ sayfasina gidelim.
        driver.get("https://html.com/tags/iframe/");

        // 2- video’yu gorecek kadar asagi inin.
        WebElement iFrameVideo = driver.findElement(By.xpath("(//iframe)[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iFrameVideo);

        driver.switchTo().frame(iFrameVideo);
        WebElement playTusu = driver.findElement(By.xpath("(//div[@style='width: 100%; height: 100%; display: block; fill: currentcolor;'])[1]"));

        // 3- videoyu izlemek icin Play tusuna basin.
        ReusableMethods.wait(2);
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);
        actions.click(playTusu).perform();
        ReusableMethods.wait(10);

        // 4- videoyu calistirdiginizi test edin.
    }
}