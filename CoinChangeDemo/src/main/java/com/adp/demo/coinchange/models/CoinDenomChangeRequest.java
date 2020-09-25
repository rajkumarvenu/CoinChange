package com.adp.demo.coinchange.models;

import org.springframework.stereotype.Component;

@Component
public class CoinDenomChangeRequest {
	
	private int QuarterCount;
	private int DimeCount;
	private int NickelCount;
	private int PennyCount;
	
	public int getQuarterCount() {
		return QuarterCount;
	}
	public void setQuarterCount(int quarterCount) {
		QuarterCount = quarterCount;
	}
	public int getDimeCount() {
		return DimeCount;
	}
	public void setDimeCount(int dimeCount) {
		DimeCount = dimeCount;
	}
	public int getNickelCount() {
		return NickelCount;
	}
	public void setNickelCount(int nickelCount) {
		NickelCount = nickelCount;
	}
	public int getPennyCount() {
		return PennyCount;
	}
	public void setPennyCount(int pennyCount) {
		PennyCount = pennyCount;
	}
}
