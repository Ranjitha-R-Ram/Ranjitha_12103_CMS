package com.atc.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.atc.model.Customer;
import com.atc.model.ProjectDetails;
import com.atc.service.ProjectDetailsService;

import jakarta.persistence.EntityManager;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProjectDetailsController {

	@Autowired
	ProjectDetailsService service;
	@Autowired
	EntityManager entityMan;

	@PostMapping("/ProjectDetailsInsert")
	public ProjectDetails project(@RequestParam("projectName") String projectName,
			@RequestParam("projectDescription") String projectDescription, @RequestParam("status") String status,
			@RequestParam("destImage") MultipartFile image, @RequestParam("customerId") int customerId)
			throws IOException {

		ProjectDetails project = new ProjectDetails();
		Customer customer = new Customer();

		project.setProjectName(projectName);
		project.setProjectDescription(projectDescription);
		project.setStatus(status);
		project.setDestImage(image.getBytes());
		customer.setCustomerId(customerId);
		project.setCustomer(customer);
		return service.project(project, image);

	}

	@PutMapping("/updateProjectDetails")
	public ProjectDetails updateProject(@RequestParam("projectId") int projectId,
			@RequestParam("projectName") String projectName,
			@RequestParam("projectDescription") String projectDescription, @RequestParam("status") String status,
			@RequestParam("destImage") MultipartFile image, @RequestParam("customerId") int customerId)
			throws IOException {

		ProjectDetails project = new ProjectDetails();
		Customer customer = new Customer();
		project.setProjectId(projectId);
		project.setProjectName(projectName);
		project.setProjectDescription(projectDescription);
		project.setStatus(status);
		project.setDestImage(image.getBytes());
		customer.setCustomerId(customerId);
		project.setCustomer(customer);
		return service.updateProject(project, image);

	}

	@GetMapping("/GetProject/{projectId}")
	public ProjectDetails performFind(@PathVariable("projectId") int projectId) {
		return service.getProject(projectId);

	}

	@GetMapping("/GetAllProject")
	public List<ProjectDetails> getAllProjects() {
		return service.getAllProjectDetails();
	}

	@GetMapping("/getProjectById/{customerId}")
	public List<ProjectDetails> getProjectById(@PathVariable("customerId") int customerId) {
		return service.getProjectById(customerId);
	}
	
	@GetMapping("/getProjectDetails/{projectId}")
	public ProjectDetails getProjectDetails(@PathVariable("projectId") int projectId) {
		return service.getProjectsDetails(projectId);
	}

}
