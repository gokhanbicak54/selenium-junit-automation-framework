package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. verbs.txt dosyasını indirelim.
        WebElement verbsDosyasi = driver.findElement(By.xpath("//*[.='verbs.txt']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", verbsDosyasi);
        ReusableMethods.wait(2);
        actions.click(verbsDosyasi).perform();
        ReusableMethods.wait(2);

        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim.
        String DinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\verbs.txt";
        Assertions.assertTrue(Files.exists(Paths.get(DinamikDosyaYolu)));
    }
}