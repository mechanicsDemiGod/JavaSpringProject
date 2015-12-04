package com.fortech.java.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.fortech.java.entities.Employee;
import com.fortech.java.entities.Project;

public class JpaProjectDAO {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public Project get(Long projId) {
		Query query = entityManager.createQuery("select p from Project p where p.projId = ?");
		query.setParameter(1, projId);
		return (Project) query.getSingleResult();
	}

	public List<Project> listAllProjects() {
		return entityManager.createQuery("select p from Project p", Project.class).getResultList();
	}

	/**
	 * get employees assigned to given project
	 * @param proj
	 * @return
	 */
	public Set<Employee> listEmployeesForProj(Project proj) {
		return proj.getEmployees();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Project proj){
		entityManager.merge(proj);
	}


}
