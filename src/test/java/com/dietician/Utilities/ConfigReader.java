package com.dietician.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	private final static String propFile = "./src/test/resources/config.properties";

	public static String getGlobalValue(String key) {
		try {
			Properties prop = new Properties();
			FileInputStream fis;
			fis = new FileInputStream(propFile);
			prop.load(fis);
			return prop.getProperty(key);
		 } catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
