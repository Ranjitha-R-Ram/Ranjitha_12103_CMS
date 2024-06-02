package com.atc.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_booking")
public class Booking {

//	************************************************
//	Author_Name:RanjithaRajaram
//	Project_Name:Construction Management System
//	************************************************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String projectType;
	private String roomSize;
	private String parking;
	private String kitchen;
	private String storeRoom;
	private String interiorDesign;
	private String swimmingPool;
	private String status;
	private String squareFeet;
	private String packageType;
	private String totalCost;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Customer customer;

	public Booking() {
		super();
	}


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getStoreRoom() {
		return storeRoom;
	}

	public void setStoreRoom(String storeRoom) {
		this.storeRoom = storeRoom;
	}

	public String getInteriorDesign() {
		return interiorDesign;
	}

	public void setInteriorDesign(String interiorDesign) {
		this.interiorDesign = interiorDesign;
	}

	public String getSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(String swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", projectType=" + projectType + ", roomSize=" + roomSize
				+ ", parking=" + parking + ", kitchen=" + kitchen + ", storeRoom=" + storeRoom + ", interiorDesign="
				+ interiorDesign + ", swimmingPool=" + swimmingPool + ", status=" + status + ", squareFeet="
				+ squareFeet + ", packageType=" + packageType + ", totalCost=" + totalCost + ", customer=" + customer
				+ "]";
	}

}
