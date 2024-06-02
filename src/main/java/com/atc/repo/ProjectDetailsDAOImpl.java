package com.atc.repo;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.atc.model.Customer;
import com.atc.model.ProjectDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class ProjectDetailsDAOImpl implements ProjectDetailsDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public ProjectDetails addProject(ProjectDetails projectDetails) {
		return entityMan.merge(projectDetails);
		
	}

	@Override
	public ProjectDetails getProject(int projectId) {
		return entityMan.find(ProjectDetails.class, projectId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> getAllProjectDetails() {
		return entityMan.createQuery("from ProjectDetails").getResultList();
	}

	@Override
	public ProjectDetails project(ProjectDetails pack, MultipartFile image) throws IOException {

		try {
			ProjectDetails project = new ProjectDetails();
			project.setProjectName(pack.getProjectName());
			project.setProjectDescription(pack.getProjectDescription());
			project.setStatus(pack.getStatus());
			project.setDestImage(image.getBytes());
			Customer customer = new Customer();
			customer.setCustomerId(0);
			project.setCustomer(customer);
			entityMan.merge(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProjectDetails updateProject(ProjectDetails pack, MultipartFile image) throws IOException {
		try {
			ProjectDetails project = new ProjectDetails();
			project.setProjectId(pack.getProjectId());
			project.setProjectName(pack.getProjectName());
			project.setProjectDescription(pack.getProjectDescription());
			project.setStatus(pack.getStatus());
			project.setDestImage(image.getBytes());
			Customer customer = new Customer();
			customer.setCustomerId(0);
			project.setCustomer(customer);
			entityMan.merge(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> getProjectById(int customerId) {
		Query query2 = entityMan.createQuery("FROM ProjectDetails b WHERE b.customer.customerId = :customerId");
		query2.setParameter("customerId", customerId);
		return query2.getResultList();
	}
	
	

	@Override
	public ProjectDetails getProjectsDetails(int projectId) {
		Query query2 = entityMan.createQuery("FROM ProjectDetails p where p.projectId=?1");
		query2.setParameter(1, projectId);
		return (ProjectDetails) query2.getSingleResult();
	}

}
