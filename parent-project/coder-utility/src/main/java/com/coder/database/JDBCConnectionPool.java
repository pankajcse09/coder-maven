package com.coder.database;
/**
 * Copyright 2010-2017 pankajbharti.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The class {@code JDBCConnectionPool} that indicates conditions that a reasonable
 * application might want to get Connection of database.
 *
 * @version 1.0
 * @author pankajbharti
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JDBCConnectionPool extends ObjectPool<Connection> {
	public static final Logger logger = Logger.getLogger(JDBCConnectionPool.class);
	private String dsn;
	private String usr;
	private String pwd;

	public JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {
		super();
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			System.out.println("JDBCConnectionPool : Exception caught: " + e.getMessage());
			logger.error("JDBCConnectionPool : JDBCConnectionPool : Exception caught: " + e);
		}
		this.dsn = dsn;
		this.usr = usr;
		this.pwd = pwd;
	}

	@Override
	protected Connection create() {
		try {
			return (DriverManager.getConnection(dsn, usr, pwd));
		} catch (SQLException e) {
			System.out.println("Connection: SQLException caught: " + e.getMessage());
			logger.error("JDBCConnectionPool : Connection : SQLException caught: " + e);
			return (null);
		}
	}

	@Override
	public void expire(Connection o) {
		try {
			((Connection) o).close();
		} catch (SQLException e) {
			System.out.println("expire : SQLException caught: " + e.getMessage());
			logger.error("JDBCConnectionPool : expire : SQLException caught: " + e);
		}
	}

	@Override
	public boolean validate(Connection o) {
		try {
			return (!((Connection) o).isClosed());
		} catch (SQLException e) {
			System.out.println("validate : SQLException caught: " + e.getMessage());
			logger.error("JDBCConnectionPool : validate : SQLException caught: " + e);
			return (false);
		}
	}
}
