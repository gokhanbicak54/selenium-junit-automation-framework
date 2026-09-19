package tests.K06_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    // 1) https://www.youtube.com adresine gidin.
    // 2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin.

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }

    @AfterAll
    public static void tearDown() {

        driver.quit();
    }

    @Test
    public void titleTest() {

        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin.
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void imageTest() {

        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin.
        WebElement imageElementi = driver.findElement(By.xpath("(//span[@class='yt-icon-shape style-scope yt-icon ytSpecIconShapeHost'])[2]"));
        Assertions.assertTrue(imageElementi.isDisplayed());
    }

    @Test
    public void searhBoxTest() {

        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled()).
        WebElement searchBoxElementi = driver.findElement(By.xpath("//input[@class='ytSearchboxComponentInput yt-searchbox-input title']"));
        Assertions.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void wrongTitleTest() {

        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin.
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assertions.assertNotEquals(expectedTitle, actualTitle);
    }
}