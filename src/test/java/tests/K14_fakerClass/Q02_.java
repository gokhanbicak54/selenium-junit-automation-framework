package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q02_ extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");

        // 2- Cookies kabul edelim
        // 3- Yeni hesap olustur butonuna basalim.
        driver.findElement(By.xpath("(//span[.='Yeni hesap oluştur'])[1]"))
                .click();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim, tarih ve cinsiyet secimlerini yapalim.
        WebElement nameInputBox = driver.findElement(By.xpath("(//div[@class='x6s0dn4 x78zum5 x1qughib xh8yej3'])[1]"));
        ReusableMethods.wait(2);
        actions.click(nameInputBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).perform();

        // 5- Kaydol tusuna basalim.
    }
}