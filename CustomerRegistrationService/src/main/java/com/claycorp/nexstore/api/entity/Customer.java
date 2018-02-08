package com.claycorp.nexstore.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {

	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String gender;
	
	private String username;
	
	private String password;
	
	private String phoneNumber;
	
	private Address address;
	
	private String city;
	
	private String state;
	
	public String getId() {
		return id;
	}

	public Customer setId(String id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmailId() {
		return emailId;
	}

	public Customer setEmailId(String emailId) {
		this.emailId = emailId;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public Customer setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Customer setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Customer setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Customer setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public Customer setAddress(Address address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Customer setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public Customer setState(String state) {
		this.state = state;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", gender=" + gender + ", username=" + username + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", city=" + city + ", state=" + state + "]";
	}	
}
