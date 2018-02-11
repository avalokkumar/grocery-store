package com.claycorp.nexstore.api.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.claycorp.nexstore.api.entity.Address;
import com.claycorp.nexstore.api.entity.Customer;
import com.claycorp.nexstore.api.model.AddressVo;
import com.claycorp.nexstore.api.model.UserVo;

@Component
public class CustomerRegistrationMapper {

	public UserVo mapUserToUserVo(Customer user) {

		UserVo userVo = new UserVo();
		AddressVo addressVo = new AddressVo();
		addressVo.setAddress1(user.getAddress().getAddress1()).setAddress2(user.getAddress().getAddress2())
				.setLandmark(user.getAddress().getLandmark()).setPinCode(user.getAddress().getPinCode());

		userVo.setUserId(user.getId()).setFirstName(user.getFirstName()).setLastName(user.getLastName())
				.setEmailId(user.getEmailId()).setGender(user.getGender()).setUsername(user.getUsername())
				.setPassword(user.getPassword()).setGender(user.getGender()).setPhoneNumber(user.getPhoneNumber())
				.setAddressVo(addressVo).setCity(user.getCity()).setState(user.getState());
		return userVo;
	}

	public List<UserVo> mapUserToUserVo(List<Customer> user) {
		return user.stream().filter(Objects::nonNull).map(this::mapUserToUserVo).collect(Collectors.toList());
	}
	
	public Customer mapUserVoToUser(UserVo userVo) {

		Customer user = new Customer();
		Address address = new Address();
		address.setAddress1(userVo.getAddressVo().getAddress1()).setAddress2(userVo.getAddressVo().getAddress2())
				.setLandmark(userVo.getAddressVo().getLandmark()).setPinCode(userVo.getAddressVo().getPinCode());

		user.setId(userVo.getUserId()).setFirstName(userVo.getFirstName()).setLastName(userVo.getLastName())
				.setEmailId(userVo.getEmailId()).setGender(userVo.getGender()).setUsername(userVo.getUsername())
				.setPassword(userVo.getPassword()).setGender(userVo.getGender()).setPhoneNumber(userVo.getPhoneNumber())
				.setAddress(address).setCity(userVo.getCity()).setState(userVo.getState());
		return user;
	}
	
	public List<Customer> mapUserVoToUser(List<UserVo> user) {
		return user.stream().filter(Objects::nonNull).map(this::mapUserVoToUser).collect(Collectors.toList());
	}
}
