package com.fortech.java.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.java.dao.JpaEmployeeDAO;
import com.fortech.java.entities.Employee;
import com.fortech.java.entities.Project;

@Transactional
public class EmployeeService{

	private JpaEmployeeDAO employeeDAO;
	
	public Employee get(Long empId) {
		return employeeDAO.get(empId);
	}

	public void setEmployeeDAO(JpaEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public List<Employee> list(){
		return employeeDAO.listAllEmployees();
	}
	
	public void save(Employee employee){
		employeeDAO.save(employee);
	}
	
	public void addProject(Long empId, Project proj){
		employeeDAO.addProject(empId, proj);
	}
	
}
