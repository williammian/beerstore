package com.hibicode.beerstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Beer {
	
	@Id
    @SequenceGenerator(name = "beer_seq", sequenceName = "beer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
	@EqualsAndHashCode.Include
    private Long id;

	@NotBlank
    private String name;

	@NotNull
    private BeerType type;

	@NotNull
	@DecimalMin("0")
    private BigDecimal volume;

}
