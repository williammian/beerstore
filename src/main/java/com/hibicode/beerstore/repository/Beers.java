package com.hibicode.beerstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;

public interface Beers extends JpaRepository<Beer, Long> {

    Optional<Beer> findByNameAndType(String name, BeerType type);

}
