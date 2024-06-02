package com.atc.service;

import java.util.List;

import com.atc.model.Builder;

public interface BuilderService {

	public Builder addBuilder(Builder builder);

	public Builder updateBuilder(Builder builder);

	public Builder getBuilder(int builderId);

	public List<Builder> getAllBuilder();

	public List<Builder> getBuilderByName(String builderName);

	public Builder loginBuilder(String builderName, String password);
}
