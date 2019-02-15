package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

public class BeerAlreadyExistException extends BusinessException {

	public BeerAlreadyExistException() {
		super("generic-3", "Beer", HttpStatus.BAD_REQUEST);
	}
	
}
