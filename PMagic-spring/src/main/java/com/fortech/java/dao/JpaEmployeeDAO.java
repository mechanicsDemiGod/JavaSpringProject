package com.fortech.java.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.fortech.java.entities.Employee;
import com.fortech.java.entities.Project;

public class JpaEmployeeDAO {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public Employee get(Long empId) {
		return entityManager.find(Employee.class, empId);
	}

	public List<Employee> listAllEmployees() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	public Set<Project> listProjectsOfEmp(Long empId) {
		Employee employee = entityManager.find(Employee.class, empId);
		return employee.getProjectList();
	}

	public void addProject(Long empId, Project project) {
		Employee employee = entityManager.find(Employee.class, empId);
		employee.getProjectList().add(project);
	}

	public void save(Employee employee) {
		entityManager.merge(employee);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Not just yet...
	 * 
	 * @param mail
	 * @param pass
	 * @param isManager
	 */
	public void createEmployee(String firstName, String lastName) {

	}

}
