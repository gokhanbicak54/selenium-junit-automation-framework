package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q13a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. “https://www.saucedemo.com” adresine gidin.
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin.
        WebElement usernameKutusu = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameKutusu.sendKeys("standard_user");

        // 3. Password kutusuna “secret_sauce” yazdirin.
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");

        // 4. Login tusuna basin.
        driver.findElement(By.xpath("//input[@id='login-button']"))
                .click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin.
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
        String ilkUrunIsmi = ilkUrunIsimElementi.getText();
        ilkUrunIsimElementi.click();

        // 6. Add to Cart butonuna basin.
        driver.findElement(By.xpath("//button[@id='add-to-cart']"))
                .click();

        // 7. Alisveris sepetine tiklayin.
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"))
                .click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin.
        WebElement sepettekiUrunIsimElementi = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunIsmi = sepettekiUrunIsimElementi.getText();
        Assertions.assertEquals(ilkUrunIsmi, sepettekiUrunIsmi);
    }
}