package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() {

        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. test.txt dosyasını indirelim.
        driver.findElement(By.xpath("//a[.='test.txt']"))
                .click();

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim.
        ReusableMethods.wait(3);
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\test.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}