package com.atc.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.atc.model.RawMaterials;
import com.atc.service.RawMaterialService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class RawMaterialController {

	@Autowired
	RawMaterialService service;

	@PostMapping("/RawMaterialInsert")
	public RawMaterials material(@RequestParam("packageType") String packageType,
			@RequestParam("storyBuilder") String storyBuilder, @RequestParam("houseType") String houseType,
			@RequestParam("paintBrand") String paintBrand, @RequestParam("aggregates") String aggregates,
			@RequestParam("cement") String cement, @RequestParam("steel") String steel,
			@RequestParam("destImage") MultipartFile image) throws IOException {

		RawMaterials material = new RawMaterials();

		material.setPackageType(packageType);
		material.setStoryBuilder(storyBuilder);
		material.setHouseType(houseType);
		material.setPaintBrand(paintBrand);
		material.setAggregates(aggregates);
		material.setCement(cement);
		material.setSteel(steel);
		material.setDestImage(image.getBytes());
		return service.materials(material, image);

	}

	@PostMapping("/AddRawMaterial")
	public RawMaterials addRawMaterial(@RequestBody RawMaterials rawMaterial) {
		return service.addRawMaterial(rawMaterial);
	}

	@GetMapping("/GetRawMaterial/{id}")
	public RawMaterials performFind(@PathVariable("id") int id) {
		return service.getRawMaterial(id);

	}

	@GetMapping("/GetAllRawMaterial")
	public List<RawMaterials> getAllRawMaterial() {
		return service.getAllRawMaterial();
	}

	@GetMapping("/GetPackageType")
	public List<RawMaterials> getPackageType() {
		return service.getPackageType();
	}

	@GetMapping("/getPackageIds")
	public List<RawMaterials> getPackageIds() {
		return service.getPackageIds();
	}

}
