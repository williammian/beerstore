package com.hibicode.beerstore.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.BeerService;

@RestController
@RequestMapping("/beers")
public class BeerResource {
	
	@Autowired
	private Beers beers;
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping
	public List<Beer> all(){
		return beers.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Beer create(@Valid @RequestBody Beer beer) {
		return beerService.save(beer);
	}
	
	@PutMapping("/{id}")
    public Beer update(@PathVariable Long id, @Valid @RequestBody Beer beer) {
        beer.setId(id);
        return beerService.save(beer);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		beerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
