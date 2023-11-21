package com.dietician.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

		private static int totalRow;
		private String code;
		private String result;
		private String excelPath = ConfigReader.getexcelfilepath();

		private ExcelReader() {};
		private static ExcelReader excelReader;
		private DataFormatter formatter = new DataFormatter();
		
		public static ExcelReader getInstance() {
			if(excelReader == null) {
				excelReader = new ExcelReader();
			}
			return excelReader;
		}
		
		/**
		 * key - Sheet Name > Map
		 *               List of row > each row is a Map
		 *                  Map> key, value
		 *                   
		 *               
		 * 
		 */
		private Map<String, List<Map<String, String>>> excelSheetCache = new HashMap<>();
		
		public List<Map<String, String>> getData(String sheetName) {
			if(excelSheetCache.containsKey(sheetName)) {
				return excelSheetCache.get(sheetName);
			}
			else {
				return excelReader.readSheet(sheetName);
			}
		}
		
		private List<Map<String, String>> readSheet(String sheetName) {
			try {
				Workbook workbook = WorkbookFactory.create(new File(excelPath));
				Sheet sheet = workbook.getSheet(sheetName);
				workbook.close();
				return readSheet(sheet);
			}
			catch(IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		private List<Map<String, String>> readSheet(Sheet sheet) {
			Row row;
			Cell cell;
			totalRow = sheet.getLastRowNum();
			List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
			for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
				row = sheet.getRow(currentRow);
				int totalColumn = row.getLastCellNum();
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					cell = row.getCell(currentColumn);
					String data = formatter.formatCellValue(cell);
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, data);
				}
				excelRows.add(columnMapdata);
			}
			return excelRows;
		}
		public int countRow() {
			return totalRow;
		}	

}
