package com.app.usermanagement.service;

import java.util.List;

import com.app.usermanagement.domain.User;

public interface IUserService {

	public void addUser(User u);

	public void updateUser(User u);

	public List<User> findAll();

	public User getUserById(long id);

	public void removeUser(long id);
}
