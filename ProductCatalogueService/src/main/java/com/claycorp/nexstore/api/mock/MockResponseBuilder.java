package com.claycorp.nexstore.api.mock;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.model.Product;

@Service
public class MockResponseBuilder {

	public Product buildMockUser() {
		Product user = new Product();

		return user;
	}

	/*
	 * private Address buildAddressMock() { Address address = new Address();
	 * address.setAddress1("Church Stree1").setAddress2("Stree2").
	 * setLandmark("Park plaza").setPinCode("3424234"); return address; }
	 */
}
