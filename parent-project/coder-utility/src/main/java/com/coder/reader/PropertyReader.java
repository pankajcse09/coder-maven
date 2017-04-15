package com.coder.reader;

import java.io.InputStream;
import java.util.Properties;

import com.coder.constant.ApplicationConstants;

public class PropertyReader {
	public static String getValue(String param) throws Exception {
		Properties properties = new Properties();
		InputStream propertiesFile = new PropertyReader().getClass().getResourceAsStream("/"+ApplicationConstants.PROPERTIES_FILE_NAME_DB);
		
		properties.load(propertiesFile);

		propertiesFile.close();
		return properties.getProperty(param);
	}
}
