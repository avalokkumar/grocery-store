package com.claycorp.nexstore.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomResponse<T extends Object>{

		private List<T> payload;
		private List<CustomError> errors;
		private boolean isSuccess;
		private String correlationId;
		private String timeStamp;
		
		public CustomResponse() {
			payload = new ArrayList<>();
			errors = new ArrayList<>();
		}

		public CustomResponse(List<T> payload, List<CustomError> errors, boolean isSuccess, String correlationId,
				String timeStamp) {
			super();
			this.payload = payload;
			this.errors = errors;
			this.isSuccess = isSuccess;
			this.correlationId = correlationId;
			this.timeStamp = timeStamp;
		}

		public List<T> getPayload() {
			return payload;
		}

		public CustomResponse<T> setPayload(List<T> payload) {
			if(payload.isEmpty()) {
				this.payload = Collections.emptyList();
			}else {
				this.payload = payload;
				this.isSuccess = true;
			}
			return this;
		}

		public List<CustomError> getErrors() {
			return errors;
		}

		public CustomResponse<T> setErrors(List<CustomError> errors) {
			if(errors.isEmpty()) {
				this.errors = Collections.emptyList();
			}else {
				this.errors = errors;
				this.isSuccess = false;
			}
			return this;
		}

		public boolean isSuccess() {
			return isSuccess;
		}

		public CustomResponse<T> setSuccess(boolean isSuccess) {
			this.isSuccess = isSuccess;
			return this;
		}

		public String getCorrelationId() {
			return correlationId;
		}

		public CustomResponse<T> setCorrelationId(String correlationId) {
			this.correlationId = correlationId;
			return this;
		}

		public String getTimeStamp() {
			return timeStamp;
		}

		public CustomResponse<T> setTimeStamp(String timeStamp) {
			System.out.println("CustomResponse.setTimeStamp()****timeStamp***"+timeStamp);
			this.timeStamp = timeStamp;
			return this;
		}

		@Override
		public String toString() {
			return "CustomResponse [payload=" + payload + ", errors=" + errors + ", isSuccess=" + isSuccess
					+ ", correlationId=" + correlationId + ", timeStamp=" + timeStamp + "]";
		}
		
		
}
