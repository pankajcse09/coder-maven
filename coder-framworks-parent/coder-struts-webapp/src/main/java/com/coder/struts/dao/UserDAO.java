package com.coder.struts.dao;

import java.util.List;

import com.coder.bean.User;

public interface UserDAO {

	public void saveOrUpdateUser(User user);

	public List<User> listUser();

	public User listUserById(Long userId);

	public void deleteUser(Long userId);
}
