package com.claycorp.nexstore.api.v1.util;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Component;

import com.claycorp.nexstore.api.v1.model.CustomError;
import com.claycorp.nexstore.api.v1.model.CustomResponse;

@Component
public class ResponseBuilder<T> {
	
	public CustomResponse<T> buildResponse(List<T> payload, List<CustomError> errors) {

		CustomResponse<T> response = new CustomResponse<>();
		response.setCorrelationId(null).setErrors(errors).setPayload(payload)
				.setTimeStamp(LocalDateTime.now().toString());

		return response;
	}

}
