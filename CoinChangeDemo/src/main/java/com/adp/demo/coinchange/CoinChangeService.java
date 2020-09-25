package com.adp.demo.coinchange;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adp.demo.coinchange.common.CoinChangeConstants;
import com.adp.demo.coinchange.common.CoinChangeError;
import com.adp.demo.coinchange.common.CoinChangeException;

@Service
public class CoinChangeService {
	
	private static final Logger logger = LogManager.getLogger(CoinChangeService.class);
	
	@Value("${coin.count}")
	private int[] coinCounts;
	
	@Value("${coin.denominations}")
	private int[] coinDenom;
	
	public int getMinCoinCount(int bill) throws CoinChangeException {
		int[] coins = combineCoinAndCount(coinDenom, coinCounts);
		int count = 0;
		try {		   
		    count = getCount(coins, bill, 0, 0, 0);		    
		} catch (Exception e) {
			logger.error("Machine does not have enough cash");
			CoinChangeError error = new CoinChangeError(CoinChangeConstants.CASH_OUT_ERROR_CD, CoinChangeConstants.CASH_OUT_ERROR_MSG);
			throw new CoinChangeException(error);
		}
		return count;
	}
	
	private static int getCount(int[] nums, int target, int sum, int current, int count) throws Exception {
	    if(current > nums.length) return -1;
	    if(sum == target) return count;
	    if(sum + nums[current] <= target){
	    	//coinsUsed.add(nums[current]);
	        return getCount(nums, target, sum+nums[current], current+1, count+1);
	    } else {
	        return getCount(nums, target, sum, current+1, count);
	    }
	}
	
	private int[] combineCoinAndCount(int[] coinDenom, int[] counts) {
	    int sum = 0;
	    for (int count : counts) {
	        sum += count;
	    }
	    int[] returnArray = new int[sum];
	    int returnArrayIndex = 0;
	    for (int i = 0; i < coinDenom.length; i++) {
	        int count = counts[i];
	        while (count != 0) {
	            returnArray[returnArrayIndex] = coinDenom[i];
	            returnArrayIndex++;	            
	            count--;	            
	        }
	    }	    
	    return returnArray;
	}

}
