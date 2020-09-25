package com.adp.demo.coinchange.common;

public class CoinChangeException extends Exception { 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CoinChangeError error;
	
	public CoinChangeException(CoinChangeError error) {
		super();
		this.error = error;
	}
	
	public CoinChangeError getError() {
		return error;
	}
	public void setError(CoinChangeError error) {
		this.error = error;
	}
	
	
	

}
