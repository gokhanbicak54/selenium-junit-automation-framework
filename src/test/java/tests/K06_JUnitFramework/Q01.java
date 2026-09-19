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

public class Q01 {

    // https://www.bestbuy.com/ Adresine gidin.
    // Farkli test method’lari olusturarak asagidaki testleri yapin.

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void tearDown() {

        driver.quit();
    }

    @Test
    public void urlTest() {

        //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin.
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void titleTest() {

        //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin.
        String expectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();
        Assertions.assertFalse(actualTitle.contains(expectedTitleIcerik));
    }

    @Test
    public void logoTest() {

        //	○ logoTest => BestBuy logosunun görüntülendigini test edin.
        WebElement bestbuyLogoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assertions.assertTrue(bestbuyLogoElementi.isDisplayed());
    }

    @Test
    public void francaisLinkTest() {

        //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin.
        WebElement francaisYeziElementi = driver.findElement(By.xpath("//button[text()='Français']"));
        Assertions.assertTrue(francaisYeziElementi.isDisplayed());
    }
}