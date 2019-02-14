package com.hibicode.beerstore.service;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;

public class BeerServiceTest {
	
	private BeerService beerService;
	
	@Before
	public void setup() {
		beerService = new BeerService();
	}
	
	@Test(expected = BeerAlreadyExistException.class)
	public void should_denny_creation_of_beer_that_exists() {
		Beer newBeer = new Beer();
		newBeer.setName("Heineken");
		newBeer.setType(BeerType.LAGER);
		newBeer.setVolume(new BigDecimal("355"));
		
		beerService.save(newBeer);
	}
	
	@Test
	public void shoud_create_new_beer() {	
		Beer newBeer = new Beer();
		newBeer.setName("Heineken");
		newBeer.setType(BeerType.LAGER);
		newBeer.setVolume(new BigDecimal("355"));
		
		Beer beerSaved = beerService.save(newBeer);
		
		assertThat(beerSaved.getId(), equalTo(10L));
		assertThat(beerSaved.getName(), equalTo("Heineken"));
		assertThat(beerSaved.getType(), equalTo(BeerType.LAGER));
	}

}
