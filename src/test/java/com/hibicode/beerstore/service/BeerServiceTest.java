package com.hibicode.beerstore.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;

public class BeerServiceTest {
	
	private BeerService beerService;
	
	@Mock
	private Beers beersMocked;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		beerService = new BeerService(beersMocked);
	}
	
	@Test(expected = BeerAlreadyExistException.class)
	public void should_denny_creation_of_beer_that_exists() {
		Beer beerInDataBase = new Beer();
		beerInDataBase.setId(1L);
		beerInDataBase.setName("Heineken");
		beerInDataBase.setType(BeerType.LAGER);
		beerInDataBase.setVolume(new BigDecimal("355"));
		
		when(beersMocked.findByNameAndType("Heineken", BeerType.LAGER)).thenReturn(Optional.of(beerInDataBase));
		
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
		
		Beer newBeerInDatabase = new Beer();
        newBeerInDatabase.setId(1L);
        newBeerInDatabase.setName("Heineken");
        newBeerInDatabase.setType(BeerType.LAGER);
        when(beersMocked.save(newBeer)).thenReturn(newBeerInDatabase);
		Beer beerSaved = beerService.save(newBeer);
		
		assertThat(beerSaved.getId(), equalTo(1L));
		assertThat(beerSaved.getName(), equalTo("Heineken"));
		assertThat(beerSaved.getType(), equalTo(BeerType.LAGER));
	}

}
