package tests.K05_Webelements_Locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class Q08a extends TestBase_Each {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Add Element butonuna basin.
        driver.findElement(By.xpath("//button[@id='sub-btn']"))
                .click();

        // 3- Remove butonu’nun gorunur oldugunu test edin.
        WebElement removeButonu = driver.findElement(By.xpath("//button[@class='remove-btn']"));
        Assertions.assertTrue(removeButonu.isDisplayed());

        // 4- Remove tusuna basin.
        removeButonu.click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin.
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));
        Assertions.assertTrue(addRemoveYaziElementi.isDisplayed());
    }
}