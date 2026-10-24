package tests.K09_JsAllerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_HTML_Alerts extends TestBase_Each {

    @Test
    public void test01() {

        // Google anasayfaya gidin.
        driver.get("https://www.google.com");
        ReusableMethods.wait(2);

        // Cookies kabul edin.
        driver.findElement(By.xpath("//div[text()='Accept all']"))
                .click();
        ReusableMethods.wait(3);
    }
}