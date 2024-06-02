package com.atc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atc.controller.ProjectDetailsController;
import com.atc.model.ProjectDetails;

@SpringBootTest
class ProjectDetailsTest {

	@Autowired
	ProjectDetailsController projectDetails;
	
	@Test
	void test_getProject() {
		ProjectDetails project=projectDetails.performFind(1);
		assertNotNull(project);
	}
	
	@Test
	void test_getAllProject() {
		List<ProjectDetails> project=projectDetails.getAllProjects();
		assertNotNull(project);
	}
	
	@Test
	void test_getProjectById() {
		List<ProjectDetails> project=projectDetails.getProjectById(2);
		assertNotNull(project);
	}
	@Test
	void test_getProjectDetailst() {
		ProjectDetails project=projectDetails.getProjectDetails(1);
		assertNotNull(project);
	}
}
