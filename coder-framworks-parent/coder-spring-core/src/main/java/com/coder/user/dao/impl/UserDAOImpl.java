package com.coder.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.coder.bean.UserDetails;
import com.coder.constant.ApplicationConstants;
import com.coder.database.JDBCConnectionPool;
import com.coder.exception.ApplicationException.DAOException;
import com.coder.reader.PropertyReader;
import com.coder.reader.QueryReader;
import com.coder.user.dao.UserDAO;
import com.coder.user.manager.impl.UserManagerImpl;

@Repository
public class UserDAOImpl implements UserDAO {
	DataSource dataSource;
	Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

	@Override
	public UserDetails getUserDetails(long id) throws DAOException {
		logger.debug("UserDAOImpl : getUserDetails : Started");
		UserDetails userDetails = null;
		try {
			String driver = PropertyReader.getValue(ApplicationConstants.ORACLE_DRIVER);
			String dsn = PropertyReader.getValue(ApplicationConstants.ORACLE_URL);
			String usr = PropertyReader.getValue(ApplicationConstants.ORACLE_USER);
			String pwd = PropertyReader.getValue(ApplicationConstants.ORACLE_PASSWORD);
			JDBCConnectionPool connectionPool = new JDBCConnectionPool(driver, dsn, usr, pwd);
			Connection connection = connectionPool.checkOut();
			Statement stmt = connection.createStatement();
			String query = QueryReader.getQuery("selectUsers");
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			connection.close();
		} catch (Exception e) {
			logger.error("UserDAOImpl : getUserDetails : Exception Caught: " + e);
			throw new DAOException(e);
		}
		logger.debug("UserDAOImpl : getUserDetails : Ended");
		return userDetails;
	}

	@Override
	public void insert(UserDetails t) throws DAOException {

	}

	@Override
	public void insertNamedParameter(UserDetails user) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBatch(List<UserDetails> user) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBatchNamedParameter(List<UserDetails> user) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBatchSQL(String sql) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails findById(int userId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetails> findAll() throws DAOException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String findNameById(int userId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalCount() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}
}
