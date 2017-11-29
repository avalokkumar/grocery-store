package com.claycorp.nexstore.api.v1.model;

public class CustomError{
	private String code;
	private String message;
	private String type;
	private String status;
	
	public CustomError() {
	}
	
	public CustomError(String code, String message, String type, String status) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	
	public CustomError setCode(String code) {
		this.code = code;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public CustomError setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getType() {
		return type;
	}

	public CustomError setType(String type) {
		this.type = type;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public CustomError setStatus(String status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return "Error [code=" + code + ", message=" + message + ", type=" + type + ", status=" + status + "]";
	}
	
}