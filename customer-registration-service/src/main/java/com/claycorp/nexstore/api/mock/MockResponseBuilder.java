package com.claycorp.nexstore.api.mock;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.entity.Address;
import com.claycorp.nexstore.api.entity.Customer;

@Service
public class MockResponseBuilder {

	public Customer buildMockUser() {
		Customer user = new Customer();
		user.setFirstName("Clay").setLastName("Monstre").setEmailId("avclay@da.com").setGender("Male")
				.setUsername("avclay").setPassword("jdskah736284").setPhoneNumber("242342344")
				.setAddress(buildAddressMock()).setCity("Oregon").setState("New Jersy");

		return user;
	}

	private Address buildAddressMock() {
		Address address = new Address();
		address.setAddress1("Church Stree1").setAddress2("Stree2").setLandmark("Park plaza").setPinCode("3424234");
		return address;
	}
}
