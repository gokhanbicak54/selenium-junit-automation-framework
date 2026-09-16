package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q10a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- testotomasyonu.com anasayfasina gidelim.
        driver.get("https://www.testotomasyonu.com/");

        // 2- Arama kutusunu locate edelim.
        WebElement aramaKutusuElementi = driver.findElement(By.xpath("//input[@id='global-search']"));

        // 3- “phone” ile arama yapalim.
        aramaKutusuElementi.sendKeys("phone" + Keys.ENTER);

        // 4- Bulunan sonuc sayisini yazdiralim.
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String aramaSonucYazisiStr = aramaSonucYazisi.getText();
        aramaSonucYazisiStr = aramaSonucYazisiStr.replaceAll("\\D", "");
        int aramaSonucYazisiInt = Integer.parseInt(aramaSonucYazisiStr);
        System.out.println("Urun sayisi: " + aramaSonucYazisiInt);

        // 5- Ilk urunu tiklayalim.
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]"))
                .click();

        // 6- Urunun stokta var oldugunu test edin.
        WebElement stokYazisi = driver.findElement(By.xpath("//span[.='In Stock']"));
        String expectedStokYazisi = "In Stock";
        String actualStokYazisi = stokYazisi.getText();
        Assertions.assertEquals(expectedStokYazisi, actualStokYazisi);
    }
}