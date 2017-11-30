package com.claycorp.nexstore.api.service.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zalando.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static org.zalando.problem.Status.BAD_REQUEST;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.exception.InvalidUserException;
import com.claycorp.nexstore.api.exception.UpdateFailureException;
import com.claycorp.nexstore.api.model.CustomError;
import com.claycorp.nexstore.api.model.User;
import com.claycorp.nexstore.api.repository.UserRepository;
import com.claycorp.nexstore.api.service.CustomerRegistrationService;
import com.claycorp.nexstore.api.util.CustomerRegistrationMapper;
import com.claycorp.nexstore.api.vo.UserVo;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	private static final String SUCCESS = "Success";

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
		User user = mapper.mapUserVoToUser(userVo);
		User userFromDb = userRepo.save(user);
		UserVo userVoFromDb = mapper.mapUserToUserVo(userFromDb);
		return Arrays.asList(userVoFromDb);
	}

	@Override
	public List<UserVo> updateUserDetails(UserVo userRequest) throws UpdateFailureException {
		if (null != userRequest.getUserId() || userRequest.getUserId().isEmpty()) {
			CustomError error = new CustomError();
			error.setCode("ER31").setMessage("User Id is not passed")
					.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()))
					.setType(HttpStatus.BAD_REQUEST.getReasonPhrase());

			throw new UpdateFailureException(Arrays.asList(getUpdateFailureProblem()));
		}
		User user = mapper.mapUserVoToUser(userRequest);
		User userFromDb = userRepo.save(user);

		return Arrays.asList(mapper.mapUserToUserVo(userFromDb));
	}

	@Override
	public List<String> deleteUserDetails(String userId) throws InvalidUserException {
		User user = userRepo.findOne(userId);
		if (null == user) {
			throw new InvalidUserException(Arrays.asList(getInvalidUserException()));
		}
		userRepo.delete(userId);
		return Arrays.asList(SUCCESS);
	}

	@Override
	public List<UserVo> findUserDetails(String userId) throws InvalidUserException {
		User user = userRepo.findOne(userId);
		if (null == user) {
			throw new InvalidUserException(Arrays.asList(getInvalidUserException()));
		}
		UserVo userVo = mapper.mapUserToUserVo(user);
		return Arrays.asList(userVo);
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