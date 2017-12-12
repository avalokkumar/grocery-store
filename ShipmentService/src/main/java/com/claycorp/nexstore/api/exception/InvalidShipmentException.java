package com.claycorp.nexstore.api.exception;

import java.util.List;

import org.zalando.problem.ThrowableProblem;

public class InvalidShipmentException extends GlobalBaseException{

	private static final long serialVersionUID = 410136169268829487L;

	public InvalidShipmentException() {
	}
	
	public InvalidShipmentException(List<ThrowableProblem> problems) {
		super(problems);
	}
	
}