package com.claycorp.nexstore.api.model;

public class PriceVo {

	private String currency;
	private Double amount;

	public PriceVo() {
	}

	public PriceVo(String currency, Double amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public PriceVo setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public PriceVo setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public String toString() {
		return "Price [currency=" + currency + ", amount=" + amount + "]";
	}
}
