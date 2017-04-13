package com.coder.manager;

import com.coder.bean.UserDetails;
import com.coder.exception.ApplicationException.ManagerException;

public interface UserManager {
	public UserDetails getUserDetails(long id) throws ManagerException;
}
