package com.adp.demo.coinchange.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class CoinChangeRequest {
	
	@NotNull
	@Min(1)
	private int bill;
	
	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
	
	

}
