package com.claycorp.nexstore.api.exception;

import java.util.List;

import org.zalando.problem.ThrowableProblem;

public class UpdateFailureException extends GlobalBaseException {
	private static final long serialVersionUID = -7909243574177598587L;

	public UpdateFailureException(List<ThrowableProblem> problems) {
		super(problems);
	}

	public UpdateFailureException() {
	}
	
	
}
