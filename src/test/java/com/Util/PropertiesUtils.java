package com.Util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Properties properties = new Properties();
	private static FileReader file;

	public static void readPropertiesFile(String filePath) {
		try {
			file = new FileReader(filePath);
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getKey(String key) {
		return properties.getProperty(key);
	}

}
