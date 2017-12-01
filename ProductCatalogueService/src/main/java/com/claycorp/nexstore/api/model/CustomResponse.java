package com.claycorp.nexstore.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.zalando.problem.ThrowableProblem;

public class CustomResponse<T extends Object>{

		private List<T> payload;
		private List<ThrowableProblem> problems;
		private boolean isSuccess;
		private String correlationId;
		private String timeStamp;
		
		public CustomResponse() {
			payload = new ArrayList<>();
			problems = new ArrayList<>();
		}

		public CustomResponse(List<T> payload, List<ThrowableProblem> problems, boolean isSuccess, String correlationId,
				String timeStamp) {
			super();
			this.payload = payload;
			this.problems = problems;
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

		public List<ThrowableProblem> getProblems() {
			return problems;
		}

		public CustomResponse<T> setProblems(List<ThrowableProblem> problems) {
			if(problems.isEmpty()) {
				this.problems = Collections.emptyList();
			}else {
				this.problems = problems;
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
			return "CustomResponse [payload=" + payload + ", problems=" + problems + ", isSuccess=" + isSuccess
					+ ", correlationId=" + correlationId + ", timeStamp=" + timeStamp + "]";
		}
		
		
}
