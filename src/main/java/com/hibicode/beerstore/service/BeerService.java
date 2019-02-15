package com.hibicode.beerstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;
import com.hibicode.beerstore.service.exception.BeerNotFoundException;

@Service
public class BeerService {
	
	private Beers beers;
	
	public BeerService(@Autowired Beers beers) {
		this.beers = beers;
	}
	
	public Beer save(final Beer beer) {
        verifyIfBeerExists(beer);
        return beers.save(beer);
    }
	
	public void delete(final Long id) {
        final Optional<Beer> beer = beers.findById(id);
        if(!beer.isPresent()) {
            throw new BeerNotFoundException();
        }
        
        beers.delete(beer.get());
    }

    private void verifyIfBeerExists(final Beer beer) {
        Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());

        if (beerByNameAndType.isPresent() && (beer.isNew() || isUpdatingToADifferentBeer(beer, beerByNameAndType))) {
            throw new BeerAlreadyExistException();
        }
    }

    private boolean isUpdatingToADifferentBeer(Beer beer, Optional<Beer> beerByNameAndType) {
        return beer.alreadyExist() && !beerByNameAndType.get().equals(beer);
    }

}
