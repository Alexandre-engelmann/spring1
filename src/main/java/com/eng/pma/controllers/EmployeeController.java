package com.eng.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eng.pma.dao.EmployeeRepository;
import com.eng.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);//in the html form aProject is called project
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee) {
		//save the database
		empRepo.save(employee);
		return "redirect:/employees/new";
		
	}

}
