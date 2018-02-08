package com.claycorp.nexstore.api.entity;

public class Price {

	private String currency;
	private Double amount;
	
	public Price() {
	}
	
	public String getCurrency() {
		return currency;
	}

	public Price setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public Price setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public String toString() {
		return "Price [currency=" + currency + ", amount=" + amount + "]";
	}
}
