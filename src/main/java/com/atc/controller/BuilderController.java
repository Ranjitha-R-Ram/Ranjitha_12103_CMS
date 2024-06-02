package com.atc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.atc.model.Builder;
import com.atc.service.BuilderService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BuilderController {

	@Autowired
	BuilderService service;

	@PostMapping("/AddBuilder")
	public String addBuilder(@RequestBody Builder builder) {
		String msg = "";
		try {
			service.addBuilder(builder);
			msg = "Builder Object Saved";
		} catch (Exception e) {
			msg = "Builder Object Not Saved";
		}
		return msg;
	}

	@PutMapping("/UpdateBuilder")
	public Builder updateBuilder(@RequestBody Builder builder) {
		return service.updateBuilder(builder);
	}

	@GetMapping("/GetBuilder/{builderId}")
	public Builder performFind(@PathVariable("builderId") int builderId) {
		return service.getBuilder(builderId);

	}

	@GetMapping("/GetAllBuilder")
	public List<Builder> getAllBuilder() {
		return service.getAllBuilder();
	}

	@GetMapping("/GetName/{builderName}")
	public List<Builder> getBuilderByName(@PathVariable("builderName") String builderName) {
		return service.getBuilderByName(builderName);
	}

	@GetMapping("/loginBuilder/{builderName}/{password}")
	public Builder loginBuilder(@PathVariable("builderName") String builderName,
			@PathVariable("password") String password) {
		return service.loginBuilder(builderName, password);
	}

}
