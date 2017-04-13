package com.coder.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.coder.bean.UserDetails;
import com.coder.exception.ApplicationException.DAOException;
import com.coder.user.dao.UserDAO;
import com.coder.user.manager.impl.UserManagerImpl;

@Repository
public class UserDAOImpl implements UserDAO {
	Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

	@Override
	public UserDetails getUserDetails(long id) throws DAOException {
		logger.debug("UserDAOImpl : getUserDetails : Started");
		UserDetails userDetails = null;
		try {
			userDetails = null;
		} catch (Exception e) {
			logger.error("UserDAOImpl : getUserDetails : Exception Caught: " + e);
			throw new DAOException(e);
		}
		logger.debug("UserDAOImpl : getUserDetails : Ended");
		return userDetails;
	}

}
