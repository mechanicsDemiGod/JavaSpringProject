package com.fortech.java.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.java.dao.JpaUserDAO;
import com.fortech.java.entities.User;

//user actions - view for all, modify/add for superCEO!

@Transactional
public class UserLoginService{

	private JpaUserDAO userDAO;
	
	public User get(String mail, String pass) {
		mail = mail.trim().toLowerCase();
		return userDAO.get(mail, pass);
	}

	public List<User> list() {
		return userDAO.list();
	}
	
	public void setUserDAO(JpaUserDAO userDAO){
		this.userDAO = userDAO;
	}
}
