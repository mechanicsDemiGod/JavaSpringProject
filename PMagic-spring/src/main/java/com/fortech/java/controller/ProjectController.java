package com.fortech.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

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
import com.fortech.java.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/viewProjects", method = RequestMethod.GET)
	public String listProjects(Model model) {
		model.addAttribute("projects", projectService.list());
		return "CEOActions/listProjects";
	}

	@RequestMapping(value = "/view/{projId}", method = RequestMethod.GET)
	public String viewEmp(@PathVariable("projId") Long projId, Model model) {
		Project currentProject = projId != 0 ? projectService.get(projId) : new Project();
		model.addAttribute("currentProject", currentProject);
		return "CEOActions/modifyProj";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam Long projId, @RequestParam String prName, @RequestParam String description,
			@RequestParam Date startedWhen) {
		Project proj;
		
		if (projId != null){
			proj = projectService.get(projId);
			proj.setPrName(prName);
			proj.setDescription(description);
			proj.setStartedWhen(startedWhen);
		}else{
			proj = new Project();
			proj.setEmployees(new HashSet<Employee>());
			proj.setPrName(prName);
			proj.setDescription(description);
			proj.setStartedWhen(startedWhen);
		}
		projectService.save(proj);
		return "redirect:viewProjects";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
