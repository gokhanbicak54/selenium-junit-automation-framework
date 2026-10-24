package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q01a extends TestBase_Each {

    @Test
    public void test01() {

        // https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin.
        WebElement ddmGun = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(ddmGun);
        selectGun.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin.
        WebElement ddmAy = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ddmAy);
        selectAy.selectByValue("nisan");

        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin.
        WebElement ddmYil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(ddmYil);
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin.
        System.out.println("Gun: " + selectGun.getFirstSelectedOption().getText());
        System.out.println("Ay: " + selectAy.getFirstSelectedOption().getText());
        System.out.println("Yil: " + selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın.
        System.out.println(ddmAy.getText());

        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin.
        int expectedAyMenusuBoyutu = 13;
        int actualAyMenuBoyutu = selectAy.getOptions().size();
        Assertions.assertEquals(expectedAyMenusuBoyutu, actualAyMenuBoyutu);
    }
}