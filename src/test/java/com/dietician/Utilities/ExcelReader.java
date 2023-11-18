package com.dietician.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	String data;
	String columnHeaderName;
	String sheetName = "dietician_User_login";
	public static String excelFilePath = "./src/test/resources/Dietician API.xlsx";

	public List<String> getCellData() {
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
					data = cell.getStringCellValue();
					list.add(data);
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
