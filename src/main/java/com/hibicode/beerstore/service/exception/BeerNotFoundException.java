package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

public class BeerNotFoundException extends BusinessException {

	public BeerNotFoundException() {
		super("generic-2", "Beer", HttpStatus.NOT_FOUND);
	}
	
}
