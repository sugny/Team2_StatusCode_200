package com.dietician.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	private final static String propFile = "./src/test/resources/config.properties";

	static FileInputStream fis;
	static Properties prop;

	static {
		try {
			prop = new Properties();
			fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (IOException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public static String getGlobalValue(String key) {
		return prop.getProperty(key);
	}
	
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("Excelpath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
}
