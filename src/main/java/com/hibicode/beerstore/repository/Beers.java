package com.hibicode.beerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibicode.beerstore.model.Beer;

public interface Beers extends JpaRepository<Beer, Long> {

    

}
