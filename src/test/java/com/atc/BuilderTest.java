package com.atc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.atc.controller.BuilderController;
import com.atc.model.Builder;

@SpringBootTest
 class BuilderTest {

	@Autowired
	BuilderController builderController;

	@Test
	void test_addBuilder() {
		Builder builder = new Builder();
		builder.setBuilderName("Thamizh");
		builder.setEmailId("thamizh234@gmail.com");
		builder.setPassword("TRan@12345");
		builder.setPhoneNumber("345678899");
		String msg = "Builder Object Saved";
		String result = builderController.addBuilder(builder);
		assertEquals(msg, result);
	}

	@Test
	void test_performFind() {
		Builder builder = builderController.performFind(1);
		assertNotNull(builder);
	}

	@Test
	void test_getAllBuilder() {
		List<Builder> builder = builderController.getAllBuilder();
		assertNotNull(builder);
	}

	@Test
	void test_getBuilderByName() {
		List<Builder> builder = builderController.getBuilderByName("ArunKumar");
		assertNotNull(builder);
	}
	
	@Test
	void test_loginBuilder() {
		Builder builder=builderController.loginBuilder("ArunKumar", "Arun@12345");
		Builder result=builderController.loginBuilder("ArunKumar", "Arun@12345");
		assertEquals(builder.getBuilderId(), result.getBuilderId());
		assertEquals(builder.getBuilderName(), result.getBuilderName());
		assertEquals(builder.getEmailId(), result.getEmailId());
		assertEquals(builder.getPassword(), result.getPassword());
		assertEquals(builder.getPhoneNumber(), result.getPhoneNumber());
	}
}
