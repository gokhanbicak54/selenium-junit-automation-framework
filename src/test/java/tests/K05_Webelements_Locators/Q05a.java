package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q05a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin.
        // 2- http://zero.webappsecurity.com/ adresine gidin.
        driver.get("http://zero.webappsecurity.com/");

        // 3- “ONLINE BANKING” linkine tiklayin.
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"))
                .click();

        // 4- Resim altinda 6 islem basligi oldugunu test edin.
        List<WebElement> kategoriElementeriList = driver.findElements(By.xpath("//span[@class='headers']"));
        Assertions.assertEquals(6, kategoriElementeriList.size());

        // 5- Islem basliklari icinde “Pay Bills” oldugunu test edin.
        List<String> kategoriListesi = ReusableMethods.stringListeDondur(kategoriElementeriList);
        String arananKelime = "Pay Bills";
        Assertions.assertTrue(kategoriListesi.contains(arananKelime));
    }
}