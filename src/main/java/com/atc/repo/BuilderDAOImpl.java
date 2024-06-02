package com.atc.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atc.model.Builder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BuilderDAOImpl implements BuilderDAO {

	@Autowired
	EntityManager entityMan;

	@Override
	public Builder addBuilder(Builder builder) {
		entityMan.persist(builder);

		return builder;
	}

	@Override
	public Builder updateBuilder(Builder builder) {
		entityMan.merge(builder);
		return builder;
	}

	@Override
	public Builder getBuilder(int builderId) {
		return entityMan.find(Builder.class, builderId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Builder> getAllBuilder() {
		return entityMan.createQuery("from Builder").getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Builder> getBuilderByName(String builderName) {
		Query qry2 = entityMan.createQuery("from Builder u where u.builderName=?1");
		qry2.setParameter(1, builderName);
		return qry2.getResultList();
	}

	@Override
	public Builder loginBuilder(String builderName, String password) {
		Query query1 = entityMan.createQuery("from Builder u where u.builderName =?1 and u.password=?2");
		query1.setParameter(1, builderName);
		query1.setParameter(2, password);
		return (Builder) query1.getSingleResult();
		

	}

}
