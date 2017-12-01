package com.claycorp.nexstore.api.vo;

import com.claycorp.nexstore.api.model.Price;

public class PriceVo {

	String currency;
	Double amount;
	
	public PriceVo() {
	}

	public PriceVo(Price price) {
		this.currency = price.getCurrency();
		this.amount = price.getAmount();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PriceVo [currency=" + currency + ", amount=" + amount + "]";
	}
}
