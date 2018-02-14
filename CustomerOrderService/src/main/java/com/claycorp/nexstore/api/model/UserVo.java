package com.claycorp.nexstore.api.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("User")
public class UserVo {

	@JsonProperty(value="userId")
	private String userId;
	
	@JsonProperty(value="firstName")
	private String firstName;
	
	@JsonProperty(value="lastName")
	private String lastName;
	
	@JsonProperty(value="emailId")
	private String emailId;
	
	@JsonProperty(value="gender")
	private String gender;
	
	@JsonProperty(value="username")
	private String username;
	
	@JsonProperty(value="password")
	private String password;
	
	@JsonProperty(value="phoneNumber")
	private String phoneNumber;
	
	@JsonProperty(value="address")
	private AddressVo addressVo;
	
	@JsonProperty(value="city")
	private String city;
	
	@JsonProperty(value="state")
	private String state;

	public String getUserId() {
		return userId;
	}

	public UserVo setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserVo setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserVo setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmailId() {
		return emailId;
	}

	public UserVo setEmailId(String emailId) {
		this.emailId = emailId;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public UserVo setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserVo setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserVo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public UserVo setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public AddressVo getAddressVo() {
		return addressVo;
	}

	public UserVo setAddressVo(AddressVo addressVo) {
		this.addressVo = addressVo;
		return this;
	}

	public String getCity() {
		return city;
	}

	public UserVo setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public UserVo setState(String state) {
		this.state = state;
		return this;	
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", gender=" + gender + ", username=" + username + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", address=" + addressVo + ", city=" + city + ", state=" + state + "]";
	}	
}