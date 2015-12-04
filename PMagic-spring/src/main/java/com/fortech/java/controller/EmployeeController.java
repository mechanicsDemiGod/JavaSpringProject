package com.fortech.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.java.entities.Employee;
import com.fortech.java.entities.Project;
import com.fortech.java.services.EmployeeService;
import com.fortech.java.services.ProjectService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectService projService;

	@RequestMapping(value = "/viewEmployees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.list());
		return "CEOActions/listEmployees";
	}

	@RequestMapping(value = "/view/{empId}", method = RequestMethod.GET)
	public String viewEmp(@PathVariable("empId") Long empId, Model model) {
		model.addAttribute("currentEmployee", employeeService.get(empId));
		return "CEOActions/modifyEmp";
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param hourRate
	 * @return
	 * 
	 * 		hiredWhen - locked attribute!
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam Long empId, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam Double hourRate) {
		Employee currentEmployee = employeeService.get(empId);
		currentEmployee.setFirstName(firstName);
		currentEmployee.setLastName(lastName);
		currentEmployee.setHourRate(hourRate);
		employeeService.save(currentEmployee);
		return "redirect:viewEmployees";
	}
	
	@RequestMapping(value = "/viewProjectsOfEmployee/{empId}", method = RequestMethod.GET)
	public String projectsOfEmployee(@PathVariable("empId") Long empId, Model model){
		model.addAttribute("prOfEmp", employeeService.get(empId).getProjectList());
		model.addAttribute("empId", empId);
		return "viewPrOfEmp";
	}
	
	@RequestMapping(value = "/assignNewProj/{empId}", method = RequestMethod.GET)
	public String assignNewProj(@PathVariable("empId") Long empId, Model model){
		model.addAttribute("empId", empId);
		return "CEOActions/newProjForEmp";
	}
	
	@RequestMapping(value = "/saveNewProj", method = RequestMethod.POST)
	public String assignNewProj(@RequestParam Long empId, @RequestParam Long projId, Model model){
		Project proj = projService.get(projId);
		employeeService.addProject(empId, proj);
		model.addAttribute("empId", empId);
		return "viewPrOfEmp";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
