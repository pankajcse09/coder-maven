package com.coder.user.dao;

import com.coder.bean.UserDetails;
import com.coder.exception.ApplicationException.DAOException;
import com.coder.generic.dao.GenericDAO;

public interface UserDAO extends GenericDAO<UserDetails> {

	UserDetails getUserDetails(long id) throws DAOException;
}
