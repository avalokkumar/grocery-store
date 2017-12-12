package com.claycorp.nexstore.api.util;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;
import org.zalando.problem.ThrowableProblem;

import com.claycorp.nexstore.api.model.CustomResponse;

@Component
public class ResponseBuilder<T> {
	
	public CustomResponse<T> buildResponse(List<T> payload, List<ThrowableProblem> problems) {

		CustomResponse<T> response = new CustomResponse<>();
		response.setCorrelationId(null).setProblems(problems).setPayload(payload)
				.setTimeStamp(LocalDateTime.now().toString());

		return response;
	}

}
