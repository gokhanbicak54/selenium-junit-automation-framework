package tests.K19_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Q01 {

    @Test
    public void test01() throws IOException {

        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String excelDosyaYolu = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // - 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayin ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String expectedData12 = "Başkent (İngilizce)";
        String actualData12 = sayfa1.getRow(0).getCell(1).getStringCellValue();
        Assertions.assertEquals(expectedData12, actualData12);

        // - 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        String expectedData24 = "Kabil";
        String actualData24 = sayfa1.getRow(1).getCell(3).getStringCellValue();
        Assertions.assertEquals(expectedData24, actualData24);

        // - Ulke sayisinin 192 oldugunu test edin
        int expectedUlkeSayisi = 192;
        int actualUlkeSayisi = sayfa1.getLastRowNum();
        Assertions.assertEquals(expectedUlkeSayisi, actualUlkeSayisi);

        // - Fiziki olarak kullanilan satir sayisinin 193 oldugunu test edin
        int expectedFizikiSatirSayisi = 193;
        int actualFizikiSatirSayisi = sayfa1.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedFizikiSatirSayisi, actualFizikiSatirSayisi);

        // - Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        Map<String, String> ulkelerMap = new TreeMap<>();

        for (int i = 1; i <= sayfa1.getLastRowNum(); i++) {
            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).getStringCellValue();
            String satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).getStringCellValue();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi, satirdakiTurkceBaskentIsmi);
        }

        String expectedBaskent = "Amsterdam";
        String actualBaskent = ulkelerMap.get("Netherlands");
        Assertions.assertEquals(expectedBaskent, actualBaskent);

        // - Turkce baskent isimlerinde Ankara bulundugunu test edin
        Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));
    }
}