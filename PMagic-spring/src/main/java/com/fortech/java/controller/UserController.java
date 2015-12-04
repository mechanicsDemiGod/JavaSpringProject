package com.fortech.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.java.entities.User;
import com.fortech.java.services.UserLoginService;

/*User and manager/employee controller*/
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserLoginService userService;


	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("users", userService.list());
		return "listUsrs";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "login";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam String mail, @RequestParam String pass, Model model) {
		User currentUser = userService.get(mail, pass);
		if (!model.containsAttribute("currentUser")) { // the login might have
														// happened already
			model.addAttribute("currentUser", currentUser);
		}
		if (currentUser.isSuperCEO()) {
			model.addAttribute("role", "CEO");
			return "startPages/indexSuperCEO";
		}
		model.addAttribute("role", "EMPLOYEE");
		return "startPages/indexEmployee";
	}

	@RequestMapping(value = "/doLogout", method = RequestMethod.GET)
	public String doLogout(Model model) {
		return "redirect:loginPage";
	}
	
	/**
	 * doesn't work :(
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/backToIndex", method = RequestMethod.GET)
	public String backToMainPage(Model model) {
		if (model.asMap().get("role").equals("CEO")){
			return "startPages/indexSuperCEO";
		}
		return "startPages/indexEmployee";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}