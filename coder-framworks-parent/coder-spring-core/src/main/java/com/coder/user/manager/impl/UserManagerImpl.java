package com.coder.user.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.coder.bean.UserDetails;
import com.coder.exception.ApplicationException.DAOException;
import com.coder.exception.ApplicationException.ManagerException;
import com.coder.user.dao.UserDAO;
import com.coder.user.manager.UserManager;

@Service
public class UserManagerImpl implements UserManager {
	Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
	private UserDAO userDAOImpl;

	@Override
	public UserDetails getUserDetails(long id) throws ManagerException {
		logger.debug("UserManagerImpl : getUserDetails : Started");
		UserDetails userDetails = null;
		try {
			userDetails = userDAOImpl.getUserDetails(id);
		} catch (DAOException e) {
			logger.error("UserManagerImpl : getUserDetails : DAOException Caught: " + e);
			throw new ManagerException(e);
		}
		logger.debug("UserManagerImpl : getUserDetails : Ended");
		return userDetails;
	}

	public void setUserDAOImpl(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

}
