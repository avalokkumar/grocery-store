package com.claycorp.nexstore.api.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonClassDescription("Price")
public class PriceVo {

	@JsonProperty("currency")
	private String currencyVo;
	@JsonProperty("amount")
	private Double amountVo;

	public PriceVo() {
	}

	public String getCurrencyVo() {
		return currencyVo;
	}

	public PriceVo setCurrencyVo(String currencyVo) {
		this.currencyVo = currencyVo;
		return this;
	}

	public Double getAmountVo() {
		return amountVo;
	}

	public PriceVo setAmountVo(Double amountVo) {
		this.amountVo = amountVo;
		return this;
	}

	@Override
	public String toString() {
		return "PriceVo [currencyVo=" + currencyVo + ", amountVo=" + amountVo + "]";
	}
}
