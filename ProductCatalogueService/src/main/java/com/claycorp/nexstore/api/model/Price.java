package com.claycorp.nexstore.api.model;

import com.claycorp.nexstore.api.vo.PriceVo;

public class Price {

	String currency;
	Double amount;
	
	public Price() {
	}

	public Price(PriceVo price) {
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
		return "Price [currency=" + currency + ", amount=" + amount + "]";
	}
}
