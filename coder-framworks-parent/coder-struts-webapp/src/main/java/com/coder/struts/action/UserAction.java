package com.coder.struts.action;

import com.coder.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>  {

	@Override
	public User getModel() {
		return null;
	}

}
