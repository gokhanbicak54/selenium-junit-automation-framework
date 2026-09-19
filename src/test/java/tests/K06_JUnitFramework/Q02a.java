package tests.K06_JUnitFramework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class Q02a extends TestBase_All {

    // 1) https://www.youtube.com adresine gidin.

    @BeforeAll
    public static void setUp() {
        // Tüm testler başlamadan önce sayfa 1 kez açılır.
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {

        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin.
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test02() {

        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin.
        WebElement youtubeYazıResmi = driver.findElement(By.xpath("(//span[@class='yt-icon-shape style-scope yt-icon ytSpecIconShapeHost'])[2]"));
        Assertions.assertTrue(youtubeYazıResmi.isDisplayed());
    }

    @Test
    public void test03() {

        // ○ Search Box'in erisilebilir oldugunu test edin (isEnabled()).
        WebElement searchBox = driver.findElement(By.xpath("//form[@class='ytSearchboxComponentSearchForm']"));
        Assertions.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {

        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin.
        String unExpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assertions.assertNotEquals(unExpectedTitle, actualTitle);
    }
}
