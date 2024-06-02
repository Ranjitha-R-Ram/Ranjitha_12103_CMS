package com.atc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.atc.model.RawMaterials;
import com.atc.repo.RawMaterialDAO;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RawMaterialServiceImpl implements RawMaterialService {

	@Autowired
	RawMaterialDAO dao;

	@Override
	public RawMaterials addRawMaterial(RawMaterials rawMaterial) {
		return dao.addRawMaterial(rawMaterial);
	}

	@Override
	public RawMaterials getRawMaterial(int id) {
		return dao.getRawMaterial(id);
	}

	@Override
	public List<RawMaterials> getAllRawMaterial() {
		return dao.getAllRawMaterial();
	}

	@Override
	public List<RawMaterials> getPackageType() {
		return dao.getPackageType();
	}

	@Override
	public RawMaterials materials(RawMaterials pack, MultipartFile image) throws IOException {
		return dao.materials(pack, image);
	}

	@Override
	public List<RawMaterials> getPackageIds() {
		return dao.getPackageIds();
	}

}
