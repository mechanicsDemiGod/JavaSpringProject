package com.fortech.java.services;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.java.dao.JpaProjectDAO;
import com.fortech.java.entities.Employee;
import com.fortech.java.entities.Project;

@Transactional
public class ProjectService {

	private JpaProjectDAO projectDAO;

	public Project get(Long projId) {
		return projectDAO.get(projId);
	}

	public void setProjectDAO(JpaProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public List<Project> list() {
		return projectDAO.listAllProjects();
	}

	public void save(Project proj) {
		projectDAO.save(proj);
	}

	public Set<Employee> listEmployeesForProj(Project proj) {
		return projectDAO.listEmployeesForProj(proj);
	}

}
