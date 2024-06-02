package com.atc.model;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_projectDetails")
public class ProjectDetails {

//	************************************************
//	Author_Name:RanjithaRajaram
//	Project_Name:Construction Management System
//	************************************************

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	private String projectDescription;
	private String status;

	@Lob
	@Column(length = 1000000)
	private byte[] destImage;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Customer customer;

	public ProjectDetails() {
		super();
	}

	public ProjectDetails(int projectId, String projectName, String projectDescription, String status, byte[] destImage,
			Customer customer) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.status = status;
		this.destImage = destImage;
		this.customer = customer;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getDestImage() {
		return destImage;
	}

	public void setDestImage(byte[] destImage) {
		this.destImage = destImage;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", status=" + status + ", destImage=" + Arrays.toString(destImage)
				+ ", customer=" + customer + "]";
	}

}