package com.dietician.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dietician.Payload.DieticianLogin;
import com.dietician.Payload.PatientLogin;

       public class ExcelReader {
      public static FileInputStream fi;
       public static XSSFWorkbook workbook;
      public static XSSFSheet sheet;
         public static XSSFCell cell;
        static String cellValue;
       String columnHeaderName;
         public static String excelFilePath = "./src/test/resources/Dietician API.xlsx";
       public static List<String> getExcelData(String sheetName) {
       try {
             fi = new FileInputStream(excelFilePath);
         workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
             int rowCount = sheet.getLastRowNum();
             short colCount = sheet.getRow(0).getLastCellNum();
         List<String> list = new ArrayList<String>();
         for (int i = 1; i <= rowCount; i++) {
         XSSFRow row = sheet.getRow(i);
             for (int j = 0; j < colCount; j++) {
            cell = row.getCell(j);
            cellValue = cell.getStringCellValue();
               list.add(cellValue);
      }
    }
         
          workbook.close();
          fi.close();
        return list;
           } catch (IOException e) {
        e.printStackTrace();
               throw new RuntimeException(e);
    }
   }

  
    
   
    
       }
  
 
       
