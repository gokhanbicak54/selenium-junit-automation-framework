package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q07a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com/ sayfasina gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 2- Arama kutusuna “dress” yazip aratin.
        WebElement aramaKutusuElementi = driver.findElement(By.xpath("//input[@id='global-search']"));
        aramaKutusuElementi.sendKeys("dress" + Keys.ENTER);

        // 3- Görüntülenen sonuclarin sayisini yazdirin.
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String aramaSonucYazisiStr = aramaSonucYazisi.getText();
        aramaSonucYazisiStr = aramaSonucYazisiStr.replaceAll("\\D", "");
        int aramaSonucYazisiInt = Integer.parseInt(aramaSonucYazisiStr);
        System.out.println("Urun sayisi: " + aramaSonucYazisiInt);

        // 4- Listeden ilk urunun resmine tiklayin.
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]"))
                .click();

        // 5- Urun detayinda dress kelimesi geçtiğini test edin.
        WebElement urunIsimYazisi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedYaziIcerik = "Dress";
        String actualYazi = urunIsimYazisi.getText();
        Assertions.assertTrue(actualYazi.contains(expectedYaziIcerik));
    }
}