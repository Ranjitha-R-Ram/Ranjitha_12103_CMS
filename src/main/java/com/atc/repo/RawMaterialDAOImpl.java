package com.atc.repo;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.atc.model.RawMaterials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class RawMaterialDAOImpl implements RawMaterialDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public RawMaterials addRawMaterial(RawMaterials rawMaterial) {
		entityMan.persist(rawMaterial);
		return rawMaterial;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RawMaterials> getPackageType() {
		Query q = entityMan.createQuery("SELECT c.packageType FROM RawMaterials c");
		return  q.getResultList();
		
	}

	@Override
	public RawMaterials getRawMaterial(int id) {
		return entityMan.find(RawMaterials.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RawMaterials> getAllRawMaterial() {
		return entityMan.createQuery("from RawMaterials").getResultList();
	}

	@Override
	public RawMaterials materials(RawMaterials pack, MultipartFile image) throws IOException {
		try {
			RawMaterials materials = new RawMaterials();
			materials.setPackageType(pack.getPackageType());
			materials.setStoryBuilder(pack.getStoryBuilder());
			materials.setHouseType(pack.getHouseType());
			materials.setPaintBrand(pack.getPaintBrand());
			materials.setAggregates(pack.getAggregates());
			materials.setCement(pack.getCement());
			materials.setSteel(pack.getSteel());
			materials.setDestImage(image.getBytes());
			entityMan.persist(materials);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RawMaterials> getPackageIds() {
		Query q = entityMan.createQuery("SELECT c.id FROM RawMaterials c");
		return q.getResultList();
		
	}

} 
