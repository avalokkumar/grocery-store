package com.claycorp.nexstore.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	
	private String address1;
	private String address2;
	private String landmark;
	private String pinCode;
	
	public Address() {
	}

	public Address(String address1, String address2, String landmark, String pinCode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.landmark = landmark;
		this.pinCode = pinCode;
	}

	public String getAddress1() {
		return address1;
	}

	public Address setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public Address setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getLandmark() {
		return landmark;
	}

	public Address setLandmark(String landmark) {
		this.landmark = landmark;
		return this;
	}

	public String getPinCode() {
		return pinCode;
	}

	public Address setPinCode(String pinCode) {
		this.pinCode = pinCode;
		return this;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", landmark=" + landmark + ", pinCode="
				+ pinCode + "]";
	}
}
