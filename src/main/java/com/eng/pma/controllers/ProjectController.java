package com.eng.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eng.pma.dao.ProjectRepository;
import com.eng.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired //Spring container inject instance 
	ProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		model.addAttribute("project", aProject);//in the html form aProject is called project
		return "new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);
		return "redirect:/projects/new";
	}
}
