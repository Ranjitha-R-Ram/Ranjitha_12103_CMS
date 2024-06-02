package com.atc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.atc.model.ProjectDetails;
import com.atc.repo.ProjectDetailsDAO;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	@Autowired
	ProjectDetailsDAO dao;

	@Override
	public ProjectDetails addProject(ProjectDetails projectDetails) {
		return dao.addProject(projectDetails);
	}

	@Override
	public ProjectDetails getProject(int projectId) {
		return dao.getProject(projectId);
	}

	@Override
	public List<ProjectDetails> getAllProjectDetails() {
		return dao.getAllProjectDetails();
	}

	@Override
	public ProjectDetails project(ProjectDetails pack, MultipartFile image) throws IOException {
		return dao.project(pack, image);
	}

	@Override
	public ProjectDetails updateProject(ProjectDetails pack, MultipartFile image) throws IOException {
		return dao.updateProject(pack, image);
	}

	@Override
	public List<ProjectDetails> getProjectById(int customerId) {
		return dao.getProjectById(customerId);
	}

	@Override
	public ProjectDetails getProjectsDetails(int projectId) {
		return dao.getProjectsDetails(projectId);
	}

}
