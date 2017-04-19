package com.coder.database;
/**
 * Copyright 2010-2017 pankajbharti.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The class {@code DataSourceConnection} that indicates conditions that a reasonable
 * application might want to get Connection of database.
 *
 * @version 1.0
 * @author pankajbharti
 */
import org.apache.log4j.Logger;

public class Configuration {
	
	public static final Logger logger = Logger.getLogger(Configuration.class);
	
	public String DB_USER_NAME;
	public String DB_PASSWORD;
	public String DB_URL;
	public String DB_DRIVER;
	public Integer DB_MAX_CONNECTIONS;

	public Configuration() {
		init();
	}

	private static Configuration configuration = new Configuration();

	public static Configuration getInstance() {
		return configuration;
	}

	private void init() {
		DB_USER_NAME = "root";
		DB_PASSWORD = "root";
		DB_URL = "jdbc:mysql://localhost:3306/jmanne";
		DB_DRIVER = "com.mysql.jdbc.Driver";
		DB_MAX_CONNECTIONS = 5;
	}
}