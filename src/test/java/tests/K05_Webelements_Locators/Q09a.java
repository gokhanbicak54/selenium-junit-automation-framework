package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q09a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir class olusturun.
        // 2- https://www.testotomasyonu.com/ adresine gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 3- Browseri tam sayfa yapin.
        // 4- Sayfayi “refresh” yapin.
        driver.navigate().refresh();

        // 5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 6- Furniture linkine tiklayin.
        driver.findElement(By.xpath("(//a[.='Furniture'])[3]"))
                .click();

        // 7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin.
        WebElement minimumAramaKutusu = driver.findElement(By.xpath("//input[@class='form-control minPrice']"));
        WebElement maksimumAramaKutusu = driver.findElement(By.xpath("//input[@class='form-control maxPrice']"));
        minimumAramaKutusu.clear();
        maksimumAramaKutusu.clear();
        minimumAramaKutusu.sendKeys("40");
        maksimumAramaKutusu.sendKeys("200");
        driver.findElement(By.xpath("//div[@class='mx-3 my-2']"))
                .click();

        // 8- filtreleme sonucunda urun bulunabildigini test edin.
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String aramaSonucYazisiStr = aramaSonucYazisi.getText();
        aramaSonucYazisiStr = aramaSonucYazisiStr.replaceAll("\\D", "");
        int aramaSonucYazisiInt = Integer.parseInt(aramaSonucYazisiStr);
        Assertions.assertTrue(aramaSonucYazisiInt > 0, "Urun bulunabilirligi testi FAILED");

        // 9- Ilk urunu tiklayin.
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]"))
                .click();

        // 10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin.
        WebElement urunFiyati = driver.findElement(By.xpath("(//div[@class='price'])[1]"));
        String urunFiyatiStr = urunFiyati.getText();
        urunFiyatiStr = urunFiyatiStr.replaceAll("\\D", "");
        Double urunFiyatiDouble = Double.parseDouble(urunFiyatiStr) / 100;
        Assertions.assertTrue(urunFiyatiDouble < 200 && urunFiyatiDouble > 40, "Urun fiyati testi FAILED");
    }
}