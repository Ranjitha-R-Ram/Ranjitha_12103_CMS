package com.atc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atc.controller.RawMaterialController;
import com.atc.model.RawMaterials;

@SpringBootTest
class RawMaterialTest {

	@Autowired
	RawMaterialController rawMaterial;

	@Test
	void test_getRawMaterial() {
		RawMaterials material = rawMaterial.performFind(1);
		assertNotNull(material);
	}

	@Test
	void test_getAllRawMaterial() {
		List<RawMaterials> materials = rawMaterial.getAllRawMaterial();
		assertNotNull(materials);
	}
	
	@Test
	void test_getPackageType() {
		List<RawMaterials> material = rawMaterial.getPackageType();
		assertNotNull(material);
	}

	@Test
	void test_getPackageIds() {
		List<RawMaterials> material = rawMaterial.getPackageIds();
		assertNotNull(material);
	}
}
