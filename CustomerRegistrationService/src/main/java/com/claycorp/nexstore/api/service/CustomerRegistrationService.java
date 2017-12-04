package com.claycorp.nexstore.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claycorp.nexstore.api.exception.InvalidUserException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.vo.UserVo;

@Service
public interface CustomerRegistrationService {
	
	List<UserVo> getAllUserDetails();

	List<UserVo> addUserDetails(UserVo userRequest);

	List<UserVo> updateUserDetails(UserVo userRequest) throws UpdateFailureException;

	void deleteUserDetails(String userId) throws InvalidUserException;

	List<UserVo> findUserDetails(String userId) throws InvalidUserException;
}
