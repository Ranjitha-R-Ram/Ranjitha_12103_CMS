package com.atc.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_rawmaterial")
public class RawMaterials {

//	************************************************
//	Author_Name:RanjithaRajaram
//	Project_Name:Construction Management System
//	************************************************

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String packageType;
	private String storyBuilder;
	private String houseType;
	private String paintBrand;
	private String aggregates;
	private String cement;
	private String steel;

	@Lob
	@Column(length = 1000000)
	private byte[] destImage;

	public RawMaterials() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getStoryBuilder() {
		return storyBuilder;
	}

	public void setStoryBuilder(String storyBuilder) {
		this.storyBuilder = storyBuilder;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getPaintBrand() {
		return paintBrand;
	}

	public void setPaintBrand(String paintBrand) {
		this.paintBrand = paintBrand;
	}

	public String getAggregates() {
		return aggregates;
	}

	public void setAggregates(String aggregates) {
		this.aggregates = aggregates;
	}

	public String getCement() {
		return cement;
	}

	public void setCement(String cement) {
		this.cement = cement;
	}

	public String getSteel() {
		return steel;
	}

	public void setSteel(String steel) {
		this.steel = steel;
	}

	public byte[] getDestImage() {
		return destImage;
	}

	public void setDestImage(byte[] destImage) {
		this.destImage = destImage;
	}

	@Override
	public String toString() {
		return "RawMaterials [id=" + id + ", packageType=" + packageType + ", storyBuilder=" + storyBuilder
				+ ", houseType=" + houseType + ", paintBrand=" + paintBrand + ", aggregates=" + aggregates + ", cement="
				+ cement + ", steel=" + steel + ", destImage=" + Arrays.toString(destImage) + "]";
	}

}
