package com.claycorp.nexstore.api.handler;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import com.claycorp.nexstore.api.exception.GlobalBaseException;
import com.claycorp.nexstore.api.model.CustomResponse;
import com.claycorp.nexstore.api.util.ResponseBuilder;

@ControllerAdvice
public class BaseExceptionHandler implements ProblemHandling{

	@Autowired
	private ResponseBuilder<?> responseBuilder;
	
	@ExceptionHandler({ GlobalBaseException.class })
	public ResponseEntity<CustomResponse<?>> handleBaseException(HttpServletRequest request,
			GlobalBaseException ex) {
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(responseBuilder.buildResponse(Collections.emptyList(), ex.getProblems()));
	}
	
}