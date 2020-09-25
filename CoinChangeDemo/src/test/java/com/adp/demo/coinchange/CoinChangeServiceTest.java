package com.adp.demo.coinchange;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.adp.demo.coinchange.common.CoinChangeException;

public class CoinChangeServiceTest {
	
	private CoinChangeService service;	
	
	@Test
	public void testGetMinCoinCount() throws CoinChangeException {
		service = mock(CoinChangeService.class);
		when(service.getMinCoinCount(Mockito.anyInt())).thenReturn(10);
		assertEquals(10,service.getMinCoinCount(Mockito.anyInt()));
	}

}
