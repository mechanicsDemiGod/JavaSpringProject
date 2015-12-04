package com.fortech.java.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Employee is the master in Employee->Project relationship. Project may be
 * assigned to Employee only using Employee entity!
 *
 */
@Entity
@Table(name = "employee_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String firstName;

	private String lastName;

	private Double hourRate;

	private Date hiredWhen;

	@ManyToMany(mappedBy = "employees")
	private Set<Project> projectList = new HashSet<Project>();

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getHourRate() {
		return hourRate;
	}

	public void setHourRate(Double hourRate) {
		this.hourRate = hourRate;
	}

	public Set<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(Set<Project> projectList) {
		this.projectList = projectList;
	}

	public Date getHiredWhen() {
		return hiredWhen;
	}

	public void setHiredWhen(Date hiredWhen) {
		this.hiredWhen = hiredWhen;
	}

}
