package tests.K18_WebTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class Q03 extends TestBase_Each {

    @Test
    public void test01() {

        // 1. “https://demoqa.com/webtables” sayfasina gidin.
        driver.get("https://demoqa.com/webtables");

        // 2. Headers'da bulunan basliklari yazdirin.
        List<WebElement> headersList = driver.findElements(By.xpath("//th[@style]"));
        System.out.println("Basliklar: " + ReusableMethods.stringListeDondur(headersList));

        // 3. 3.sutunun basligini yazdirin.
        System.out.println("3. baslik: " + headersList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin.
        List<WebElement> tumDatalarList = driver.findElements(By.xpath("//tr//td"));
        System.out.println("Tum datalar: " + ReusableMethods.stringListeDondur(tumDatalarList));

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin.
        // 6. Tablodaki satir sayisini yazdirin.
        List<WebElement> satirlarList = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Satir sayisi: " + satirlarList.size());

        // 7. Tablodaki sutun sayisini yazdirin.
        System.out.println("Sutun sayisi: " + headersList.size());

        // 8. Tablodaki 3.kolonu yazdirin.
        List<WebElement> ucuncuSutunList = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        System.out.println("3. sutun: " + ReusableMethods.stringListeDondur(ucuncuSutunList));

        // 9. Tabloda "First Name" i Cierra olan kisinin Salary'sini yazdirin.
        for (int i = 1; i <= satirlarList.size(); i++) {
            String satirdakiSutun = getData(i, 1);
            if (satirdakiSutun.equalsIgnoreCase("Cierra")) {
                System.out.println("Cierra's Salary: " + getData(i, 5));
            }
        }

        // 10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirsin.
        System.out.println("Istenen Datalar: ");
        System.out.println(getData(1, 1));
        System.out.println(getData(2, 2));
        System.out.println(getData(3, 3));
    }

    public String getData(int satirNo, int sutunNo) {
        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}