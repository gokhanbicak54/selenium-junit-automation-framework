package tests.K06_JUnitFramework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class Q01a extends TestBase_All {

    // https://www.bestbuy.com/ adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin.

    @BeforeAll
    public static void setUp() {
        // Tüm testler başlamadan önce sayfa 1 kez açılır.
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test01() {

        // ○ Sayfa URL’inin https://www.bestbuy.com/ 'a esit oldugunu test edin.
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void test02() {

        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin.
        String unexpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();
        Assertions.assertFalse(actualTitle.contains(unexpectedTitleIcerik));
    }

    @Test
    public void test03() {

        // ○ logoTest => BestBuy logosunun görüntülendigini test edin.
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assertions.assertTrue(bestBuyLogo.isDisplayed());
    }

    @Test
    public void test04() {

        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin.
        WebElement fransizcaYaziElementi = driver.findElement(By.xpath("//button[text()='Français']"));
        Assertions.assertTrue(fransizcaYaziElementi.isDisplayed());
    }
}