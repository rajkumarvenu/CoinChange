package com.adp.demo.coinchange;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adp.demo.coinchange.common.CoinChangeException;
import com.adp.demo.coinchange.models.CoinChangeRequest;

@RestController
@RequestMapping("/coins")
public class CoinChangeController {
	
	@Autowired
	private CoinChangeService service;
	
	@PostMapping
	public ResponseEntity<?> getMinimumCount(@Valid @RequestBody CoinChangeRequest request, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			String errorMessage = "Invalid request parameter: Bill currency is not valid";
		    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		try {
			int count = service.getMinCoinCount(request.getBill()*100);
			return new ResponseEntity<>(count,HttpStatus.OK);
		} catch (CoinChangeException ex) {
			return new ResponseEntity<>(ex.getError(),HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/{bill}")
	public ResponseEntity<?> getMinimumCount(@PathVariable("bill") int bill) {
		/*if(bindingResult.hasFieldErrors()) {
			String errorMessage = "Invalid request parameter: Bill currency is not valid";
		    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}*/
		try {
			int count = service.getMinCoinCount(bill*100);
			return new ResponseEntity<>(count,HttpStatus.OK);
		} catch (CoinChangeException ex) {
			return new ResponseEntity<>(ex.getError(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

}
