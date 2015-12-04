package com.fortech.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fortech.java.entities.User;

public class JpaUserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public User get(String mail, String pass) {
		Query query = entityManager.createQuery("select u from User u where u.mail = ? and u.pass = ?");
		query.setParameter(1, mail);
		query.setParameter(2, pass);
		return (User) query.getSingleResult();
	}
	
	public List<User> list(){
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void createNewUser(String mail, String pass, boolean isManager){
		User newUser = new User();
		newUser.setMail(mail);
		newUser.setPass(pass);
		newUser.setSuperCEO(false); // the superCEO is unique
	}
	
}
