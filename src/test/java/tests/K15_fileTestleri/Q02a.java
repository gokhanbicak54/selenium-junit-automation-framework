package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. https://the-internet.herokuapp.com/upload adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2. chooseFile butonuna basalim.
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));

        // 3. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/K15_fileTestleri/deneme.txt";
        chooseFile.sendKeys(dosyaYolu);

        // 4. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']"))
                .click();

        // 5. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[.='File Uploaded!']"));
        String expectedYazi = "File Uploaded!";
        String actualYazi = sonucYazisi.getText();
        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}