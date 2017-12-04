package com.claycorp.nexstore.api.service.impl;

import static org.zalando.problem.Status.BAD_REQUEST;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.exception.InvalidUserException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.model.User;
import com.claycorp.nexstore.api.repository.UserRepository;
import com.claycorp.nexstore.api.service.CustomerRegistrationService;
import com.claycorp.nexstore.api.util.CustomerRegistrationMapper;
import com.claycorp.nexstore.api.vo.UserVo;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CustomerRegistrationMapper mapper;

	@Override
	public List<UserVo> getAllUserDetails() {
		List<User> users = userRepo.findAll();
		return mapper.mapUserToUserVo(users);
	}

	@Override
	public List<UserVo> addUserDetails(UserVo userVo) {
		return Arrays.asList(mapper.mapUserToUserVo(userRepo.save(mapper.mapUserVoToUser(userVo))));
	}

	@Override
	public List<UserVo> updateUserDetails(UserVo userRequest) throws UpdateFailureException {
		if (null != userRequest.getUserId() || userRequest.getUserId().isEmpty()) {
			throw new UpdateFailureException(Arrays.asList(getUpdateFailureProblem()));
		}
		return Arrays.asList(mapper.mapUserToUserVo(userRepo.save(mapper.mapUserVoToUser(userRequest))));
	}

	@Override
	public void deleteUserDetails(String userId) throws InvalidUserException {
		User user = userRepo.findOne(userId);
		if (null == user) {
			throw new InvalidUserException(Arrays.asList(getInvalidUserException()));
		}
		userRepo.delete(userId);
	}

	@Override
	public List<UserVo> findUserDetails(String userId) throws InvalidUserException {
		User user = userRepo.findOne(userId);
		if (null == user) {
			throw new InvalidUserException(Arrays.asList(getInvalidUserException()));
		}
		return Arrays.asList(mapper.mapUserToUserVo(user));
	}

	private ThrowableProblem getInvalidUserException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/customers")).withStatus(BAD_REQUEST)
				.with("code", "ER32").with("message", "Invalid User Id provided").build();
	}

	private ThrowableProblem getUpdateFailureProblem() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/customers")).withStatus(BAD_REQUEST)
				.with("code", "ER31").with("message", "User Id is not provided in request").build();
	}
}