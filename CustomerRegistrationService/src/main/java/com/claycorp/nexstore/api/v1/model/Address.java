package com.claycorp.nexstore.api.v1.model;

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

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", landmark=" + landmark + ", pinCode="
				+ pinCode + "]";
	}
}
