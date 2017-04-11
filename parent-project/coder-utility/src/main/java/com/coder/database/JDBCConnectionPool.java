package com.coder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnectionPool extends ObjectPool<Connection> {
	public static final Logger logger = LoggerFactory.getLogger(JDBCConnectionPool.class);

	private String dsn;
	private String usr;
	private String pwd;

	public JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {
		super();
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			System.out.println("JDBCConnectionPool : Exception caught: " + e.getMessage());
			logger.error("JDBCConnectionPool : Exception caught: " + e);
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
