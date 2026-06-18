package tests.K13_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q07 extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);

        // 1- https://www.testotomasyonu.com sayfasina gidelim.
        driver.get("https://www.testotomasyonu.com");

        // 2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin.
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='search-input']"));
        ReusableMethods.wait(2);
        actions.click(aramaKutusu)
                .sendKeys("DELL Core I3" + Keys.ENTER)
                .perform();

        // 3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin.
        WebElement bulunanUrun = driver.findElement(By.xpath("//a[@class='prod-title mb-3 ']"));
        String expectedUrunIsimIcerik = "DELL Core I3";
        String actualUrunIsim = bulunanUrun.getText();
        Assertions.assertTrue(actualUrunIsim.contains(expectedUrunIsimIcerik));
    }
}