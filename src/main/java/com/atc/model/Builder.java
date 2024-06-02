package com.atc.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_builder")
public class Builder {
//	************************************************
//	Author_Name:RanjithaRajaram
//	Project_Name:Construction Management System
//	************************************************

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int builderId;
	private String builderName;
	private String emailId;
	private String password;
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "builderId")
	private List<Booking> booking;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "builderId")
	private List<ProjectDetails> projectDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "builderId")
	private List<RawMaterials> rawMaterial;

	public Builder() {
		super();

	}

	public int getBuilderId() {
		return builderId;
	}

	public void setBuilderId(int builderId) {
		this.builderId = builderId;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}

	public List<RawMaterials> getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(List<RawMaterials> rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

	@Override
	public String toString() {
		return "Builder [builderId=" + builderId + ", builderName=" + builderName + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", booking=" + booking
				+ ", projectDetails=" + projectDetails + ", rawMaterial=" + rawMaterial + "]";
	}

}
