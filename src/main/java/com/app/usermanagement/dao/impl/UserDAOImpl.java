package com.app.usermanagement.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.app.usermanagement.dao.IUserDAO;
import com.app.usermanagement.domain.User;

@Repository
public class UserDAOImpl implements IUserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(u);
		logger.info("User saved successfully, User Details: " + u);
	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User updated successfully, User Details: " + u);
	}

	@Override
	public User getUserById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Long(id));
		logger.info("User loaded successfully, User Details: " + u);
		return u;
	}

	@Override
	public void removeUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Long(id));
		if (u != null) {
			session.delete(u);
		}
		logger.info("User deleted successfully, User Details: " + u);
	}

	@Override
	public List<User> findAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("FROM User").list();
		for (User u : users) {
			logger.info("User List: " + u);
		}
		return users;
	}
}
