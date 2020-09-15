package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {

        String dosyaYolu = "src/test/resources/ULKELER.xlsx";

        //Acmak icin
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //Okumak icin
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Yazma icin FileOutputStream class'indan bir nesne olusturulmali
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);

        //ÜLKELER BASKENT NEYI MESHUR NÜFUS
        //0. indexteki satırın, 3. indexteki hücresine NÜFUS hücresi ekleyelim
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80Milyon");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10Milyon");

        // 0.indexteki satırın, 1. indexindeki hücreyi silelim (BAŞKENTLER)
        Cell silmekIstedigimizHucre = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstedigimizHucre);

        //1. indexteki satırı silelim (Almanya satırını silelim)
        Row silmekIstedigimizSatir  = workbook.getSheetAt(0).getRow(1);
        workbook.getSheetAt(0).removeRow(silmekIstedigimizSatir);




        // yaptığımız değişiklikleri excel dosyasına aktarır, veriyi yazar ve kaydeder.
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();


    }


}
