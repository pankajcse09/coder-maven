package com.coder.user.dao;

import com.coder.bean.UserDetails;
import com.coder.exception.ApplicationException.DAOException;

public interface UserDAO {
	UserDetails getUserDetails(long id) throws DAOException;
}
