package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q12a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- C01_TekrarTesti isimli bir class olusturun.
        // 2- https://www.google.com/ adresine gidin.
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin.
        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin.
        String expectedTitleIcerik = "Google";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 5- Arama cubuguna “Nutella” yazip aratin.
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
}