package com.atc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atc.model.Builder;
import com.atc.repo.BuilderDAO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BuilderServiceImpl implements BuilderService {

	@Autowired
	BuilderDAO dao;

	@Override
	public Builder addBuilder(Builder builder) {
		return dao.addBuilder(builder);
	}

	@Override
	public Builder updateBuilder(Builder builder) {
		return dao.updateBuilder(builder);
	}

	@Override
	public Builder getBuilder(int builderId) {
		return dao.getBuilder(builderId);
	}

	@Override
	public List<Builder> getAllBuilder() {
		return dao.getAllBuilder();
	}

	@Override
	public List<Builder> getBuilderByName(String builderName) {
		return dao.getBuilderByName(builderName);
	}

	@Override
	public Builder loginBuilder(String builderName, String password) {
		return dao.loginBuilder(builderName, password);
	}

}
