package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02a extends TestBase_Each {

    @Test
    public void test01() {

        // ●  https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdirin.
        WebElement ddmList = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddmList);
        select.selectByIndex(1);

        // 2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdirin.
        select.selectByValue("2");

        // 3. Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdirin.
        select.selectByVisibleText("Option 1");

        // 4. Tüm dropdown değerleri(value) yazdirin.
        System.out.println(ddmList.getText());

        // 5. Dropdown’un boyutunun 4 oldugunu test edin.
        int expectedDdmSize = 4;
        int actualDdmSize = select.getOptions().size(); // 3
        Assertions.assertEquals(expectedDdmSize, actualDdmSize);
    }
}