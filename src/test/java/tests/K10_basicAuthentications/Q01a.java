package tests.K10_basicAuthentications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Bir class olusturun : BasicAuthentication
        // 2- https://testotomasyonu.com/basicauth sayfasina gidin.
        // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin.
        // Html komutu : https://username:password@URL
        // Username : membername
        // password : sunflower
        // 4- Basarili sekilde sayfaya girildigini dogrulayin.

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        WebElement sonucYazisi = driver.findElement(By.xpath("//i[.='Congratulations! You are logged in as: membername']"));
        String expectedYaziIcerik = "Congratulations";
        String actualYazi = sonucYazisi.getText();
        Assertions.assertTrue(actualYazi.contains(expectedYaziIcerik));
    }
}