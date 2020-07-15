package com.eng.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eng.pma.dao.EmployeeRepository;
import com.eng.pma.dao.ProjectRepository;
import com.eng.pma.entities.Employee;
import com.eng.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	@GetMapping("/")
	public String displayHome(Model model) {
		
		// we are querying the database for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		//we are querying the database for employyes
		List<Employee> employee = empRepo.findAll();
		model.addAttribute("anEmployee", employee);
		return "home";
		
	}

}
