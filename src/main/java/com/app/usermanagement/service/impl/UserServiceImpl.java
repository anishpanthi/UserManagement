package com.app.usermanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.usermanagement.dao.IUserDAO;
import com.app.usermanagement.domain.User;
import com.app.usermanagement.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;
	
	public void setUserDAO(IUserDAO userDAO){
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User u) {
		userDAO.addUser(u);

	}

	@Override
	public void updateUser(User u) {
		userDAO.updateUser(u);

	}

	@Override
	public List<User> findAll() {
		return userDAO.findAllUser();
	}

	@Override
	public User getUserById(long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void removeUser(long id) {
		userDAO.removeUser(id);
	}
}
