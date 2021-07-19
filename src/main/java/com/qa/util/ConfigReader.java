package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	
	private Properties properties;
	
	/**
	 *  This method is used to load the properties from config.properties file
	 * @returnIt returns Properties object
	 */
	
	public Properties initProperties()
	{
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}

}
