package com.app.usermanagement.dao;

import java.util.List;

import com.app.usermanagement.domain.User;

public interface IUserDAO {

	public void addUser(User u);

	public void updateUser(User u);

	public User getUserById(long id);

	public void removeUser(long id);

	public List<User> findAllUser();

}
