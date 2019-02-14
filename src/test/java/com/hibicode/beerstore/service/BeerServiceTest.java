package com.hibicode.beerstore.service;

import java.math.BigDecimal;

import org.junit.Test;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;

public class BeerServiceTest {
	
	@Test(expected = BeerAlreadyExistException.class)
	public void should_denny_creation_of_beer_that_exists() {
		BeerService beerService = new BeerService();
		
		Beer newBeer = new Beer();
		newBeer.setName("Heineken");
		newBeer.setType(BeerType.LAGER);
		newBeer.setVolume(new BigDecimal("355"));
		beerService.save(newBeer);
	}

}
