package com.claycorp.nexstore.api.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("Address")
public class AddressVo {
	
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("landmark")
	private String landmark;
	@JsonProperty("pinCode")
	private String pinCode;
	
	public AddressVo() {
	}

	public AddressVo(String address1, String address2, String landmark, String pinCode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.landmark = landmark;
		this.pinCode = pinCode;
	}

	public String getAddress1() {
		return address1;
	}

	public AddressVo setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public AddressVo setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getLandmark() {
		return landmark;
	}

	public AddressVo setLandmark(String landmark) {
		this.landmark = landmark;
		return this;
	}

	public String getPinCode() {
		return pinCode;
	}

	public AddressVo setPinCode(String pinCode) {
		this.pinCode = pinCode;
		return this;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", landmark=" + landmark + ", pinCode="
				+ pinCode + "]";
	}
}
