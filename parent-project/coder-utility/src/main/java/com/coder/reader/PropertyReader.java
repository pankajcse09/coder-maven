package com.coder.reader;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.coder.constant.ApplicationConstants;

public class PropertyReader {
	public static final Logger logger = Logger.getLogger(PropertyReader.class);
	public static String getValue(String param) throws Exception {
		logger.info("PropertyReader : getValue : Started");
		logger.info("PropertyReader : getValue : for: "+param);
		Properties properties = new Properties();
		InputStream propertiesFile = new PropertyReader().getClass().getResourceAsStream("/"+ApplicationConstants.PROPERTIES_FILE_NAME_DB);
		
		properties.load(propertiesFile);

		propertiesFile.close();
		return properties.getProperty(param);
	}
}
