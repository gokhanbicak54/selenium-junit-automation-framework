package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q07a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com sayfasina gidelim.
        driver.get("https://www.testotomasyonu.com");

        // 2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin.
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search']"));
        Actions actions = new Actions(driver);
        ReusableMethods.wait(2);
        actions.click(searchBox)
                .sendKeys("DELL Core I3" + Keys.ENTER)
                .perform();

        // 3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin.
        WebElement urunIsmi = driver.findElement(By.xpath("//a[@class='prod-title mb-3 ']"));
        String expectedIsimIcerik = "DELL Core I3";
        String actualIsim = urunIsmi.getText();
        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));
    }
}