package tests.K18_WebTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q02 extends TestBase_Each {

    @Test
    public void test01() {

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin.
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers'da bulunan basliklari yazdirin.
        List<WebElement> headersBasliklariList = driver.findElements(By.xpath("//div[@role='hrow']/div[@role='hdata']"));
        System.out.println("Basliklar: " + ReusableMethods.stringListeDondur(headersBasliklariList));

        // 3. 3. sutunun basligini yazdirin.
        System.out.println("3. sutunun basligi: " + headersBasliklariList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin.
        List<WebElement> tumDatalarList = driver.findElements(By.xpath("//div[@role='trow']/div[@role='tdata']"));
        System.out.println("Tum datalar: " + ReusableMethods.stringListeDondur(tumDatalarList));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin.
        System.out.println("Data sayisi: " + tumDatalarList.size());

        // 6. Tablodaki satir sayisini yazdirin.
        List<WebElement> satirlarList = driver.findElements(By.xpath("//div[@role='trow']"));
        System.out.println("Satir sayisi: " + satirlarList.size());

        // 7. Tablodaki sutun sayisini yazdirin.
        System.out.println("Sutun sayisi: " + headersBasliklariList.size());

        // 8. Tablodaki 3.kolonu yazdirin.
        List<WebElement> ucuncuKolonList = driver.findElements(By.xpath("//div[@role='trow']/div[@role='tdata'][3]"));
        System.out.println("3. kolon: " + ReusableMethods.stringListeDondur(ucuncuKolonList));

        // 9. Tabloda "Category" si Furniture olan urunun fiyatini yazdirin.
        for (int i = 1; i <= satirlarList.size(); i++) {
            String satirdakiSutun = getData(i, 2);
            if (satirdakiSutun.equalsIgnoreCase("Furniture")) {
                System.out.println("Urun fiyati: " + getData(i, 3));
            }
        }

        // 10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin.
        System.out.println("Istenen Datalar: ");
        System.out.println(getData(1, 1));
        System.out.println(getData(2, 2));
        System.out.println(getData(3, 3));
        System.out.println(getData(4, 4));
    }

    public String getData(int satirNo, int sutunNo) {
        String dinamikXpath = "//div[@role='trow'][" + satirNo + "]/div[@role='tdata'][" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}