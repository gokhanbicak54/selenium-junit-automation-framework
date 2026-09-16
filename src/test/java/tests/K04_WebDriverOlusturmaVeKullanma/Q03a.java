package tests.K04_WebDriverOlusturmaVeKullanma;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Q03a extends TestBase_Each {

    @Test
    public void test01() {

        // 1. https://www.testotomasyonu.com/ sayfasina gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfanin konumunu ve boyutlarini yazdirin.
        System.out.println("Sayfanin konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutu: " + driver.manage().window().getSize());

        // 3. Sayfayi simge durumuna getirin.
        driver.manage().window().minimize();

        // 4. Simge durumunda 3 saniye bekleyip sayfayi maximize yapin.
        ReusableMethods.wait(3);
        driver.manage().window().maximize();

        // 5. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin.
        System.out.println("Sayfanin maximize konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfanin maximize boyutu: " + driver.manage().window().getSize());

        // 6. Sayfayi fullscreen yapin.
        ReusableMethods.wait(3);
        driver.manage().window().fullscreen();

        // 7. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin.
        System.out.println("Sayfanin fullscreen konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfanin fullscreen boyutu: " + driver.manage().window().getSize());

        // 8. Sayfanin konumunu pixel olarak (50, 50)’ye getirin.
        driver.manage().window().setPosition(new Point(50, 50));

        // 9. Sayfa boyutunu pixel olarak (1000, 500)’ye ayarlayin.
        driver.manage().window().setSize(new Dimension(1000, 500));
    }
}