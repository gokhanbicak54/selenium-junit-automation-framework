package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class Q02a_ extends TestBase_Each {

    @Test
    public void test01() {

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");

        // 2- Cookies kabul edelim.
        // 3- Yeni hesap olustur butonuna basalim.
        WebElement yeniHesapOlustur = driver.findElement(By.xpath("(//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[3]"));
        actions.click(yeniHesapOlustur).perform();

        // 4- Ad, soyad, mail ve sifre kutularina deger yazalim, tarih ve cinsiyet secimlerini yapalim ve kaydol tusuna basalim.
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        // 5- Kaydol tusuna basalim.
    }
}