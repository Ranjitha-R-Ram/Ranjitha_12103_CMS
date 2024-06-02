package com.atc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.atc.model.ProjectDetails;

public interface ProjectDetailsService {

	public ProjectDetails addProject(ProjectDetails projectDetails);

	public ProjectDetails getProject(int projectId);

	public List<ProjectDetails> getAllProjectDetails();

	public ProjectDetails project(ProjectDetails pack, MultipartFile image) throws IOException;
	
	public ProjectDetails updateProject(ProjectDetails pack, MultipartFile image) throws IOException;
	
	public List<ProjectDetails> getProjectById(int customerId);

	public ProjectDetails getProjectsDetails(int projectId);
}
