package tests.K18_WebTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q01 extends TestBase_Each {

    @Test
    public void test01() {

        // 1. "https://testotomasyonu.com/webtables" adresine gidin.
        driver.get("https://testotomasyonu.com/webtables");

        // 2. Web table tum body’sini yazdirin.
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body elementi: \n" + tumBodyElementi.getText());

        // 3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin.
        String expectedWebTabloIcerik = "Comfortable Gaming Chair";
        String actualWebTablo = tumBodyElementi.getText();
        Assertions.assertTrue(actualWebTablo.contains(expectedWebTabloIcerik));

        // 4. Web table’daki satir sayisinin 5 oldugunu test edin.
        List<WebElement> satirSayisiList = driver.findElements(By.xpath("//tbody//tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirSayisiList.size();
        Assertions.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 5. Tum satirlari yazdirin.
        System.out.println(satirSayisiList);
        System.out.println(ReusableMethods.stringListeDondur(satirSayisiList));

        // 6. Web table’daki sutun sayisinin 4 olduğunu test edin.
        List<WebElement> sutunSayisiList = driver.findElements(By.xpath("//tbody//tr[1]//td"));
        int expectedSutunSayisi = 4;
        int actualSutunSayisi = sutunSayisiList.size();
        Assertions.assertEquals(expectedSutunSayisi, actualSutunSayisi);

        // 7. 3.sutunu yazdirin.
        List<WebElement> ucuncuSutunElementList = driver.findElements(By.xpath("//tbody//tr//td[3]"));
        System.out.println("Ucuncu elemenleri list: \n" + ReusableMethods.stringListeDondur(ucuncuSutunElementList));

        // 8. Tablodaki basliklari yazdirin.
        List<WebElement> tabloBasliklariList = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Tablodaki basliklar: \n" + ReusableMethods.stringListeDondur(tabloBasliklariList));

        // 9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun.
        System.out.println("1.satir, 2.sutun: " + getData(1,2));
        System.out.println("2.satir, 3.sutun: " + getData(2,3));
        System.out.println("3.satir, 4.sutun: " + getData(3,4));
        System.out.println("4.satir, 1.sutun: " + getData(4,1));
        System.out.println("5.satir, 2.sutun: " + getData(5,2));

        // 10. 4.satirdaki category degerinin "Furniture" oldugunu test edin.
        String expected42 = "Furniture";
        String actual42 = getData(4, 2);
        Assertions.assertEquals(expected42, actual42);
    }

    public String getData(int satirNo, int sutunNo) {
        String istenenData = "";
        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));
        istenenData = istenenHucreElementi.getText();
        return istenenData;
    }
}