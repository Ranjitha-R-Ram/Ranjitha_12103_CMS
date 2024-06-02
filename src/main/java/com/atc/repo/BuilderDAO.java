package com.atc.repo;

import java.util.List;
import com.atc.model.Builder;

public interface BuilderDAO {

	public Builder addBuilder(Builder builder);

	public Builder updateBuilder(Builder builder);

	public Builder getBuilder(int builderId);

	public List<Builder> getAllBuilder();

	public List<Builder> getBuilderByName(String builderName);

	public Builder loginBuilder(String builderName, String password);

}
