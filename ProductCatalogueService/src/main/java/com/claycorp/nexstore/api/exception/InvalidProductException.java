package com.claycorp.nexstore.api.exception;

import java.util.List;

import org.zalando.problem.ThrowableProblem;

public class InvalidProductException extends GlobalBaseException{

	private static final long serialVersionUID = 410136169268829487L;

	public InvalidProductException() {
	}
	
	public InvalidProductException(List<ThrowableProblem> problems) {
		super(problems);
	}
	
}