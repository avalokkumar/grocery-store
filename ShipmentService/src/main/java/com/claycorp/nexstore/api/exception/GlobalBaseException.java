package com.claycorp.nexstore.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.zalando.problem.ThrowableProblem;

public class GlobalBaseException extends Exception{

	private static final long serialVersionUID = -3834711485701783938L;
	
	private List<ThrowableProblem> problems = new ArrayList<>();

	public GlobalBaseException() {
	}
	
	public GlobalBaseException(List<ThrowableProblem> problems) {
		super();
		this.problems = problems;
	}

	public List<ThrowableProblem> getProblems() {
		return problems;
	}

	public void setProblems(List<ThrowableProblem> problems) {
		this.problems = problems;
	}

}