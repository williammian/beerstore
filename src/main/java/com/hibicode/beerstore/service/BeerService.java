package com.hibicode.beerstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;

@Service
public class BeerService {
	
	@Autowired
	private Beers beers;
	
	public Beer save(final Beer beer) {
		Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());  
		
		if(beerByNameAndType.isPresent()) {
			throw new BeerAlreadyExistException();
		}
		
		return beers.save(beer);
	}

}
