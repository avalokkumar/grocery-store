package com.claycorp.nexstore.api.util;

import static org.zalando.problem.Status.BAD_REQUEST;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;

@Component
public class ExceptionUtil {

	public ThrowableProblem getInvalidOrderException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/orders")).withStatus(BAD_REQUEST)
				.with("code", "ER32").with("message", "Order Id is not provided in the request").build();
	}

	public ThrowableProblem getUpdateFailureException() {
		return Problem.builder().withType(URI.create("/api/dev/claycorp/api/v1/orders")).withStatus(BAD_REQUEST)
				.with("code", "ER31").with("message", "Invalid Order Id provided").build();
	}
}
