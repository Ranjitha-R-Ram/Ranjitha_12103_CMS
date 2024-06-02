package com.atc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.atc.model.RawMaterials;

public interface RawMaterialService {

	public RawMaterials addRawMaterial(RawMaterials rawMaterial);

	public RawMaterials getRawMaterial(int id);

	public List<RawMaterials> getAllRawMaterial();

	public List<RawMaterials> getPackageType();

	public RawMaterials materials(RawMaterials pack, MultipartFile image) throws IOException;
	
	public List<RawMaterials> getPackageIds();

}
