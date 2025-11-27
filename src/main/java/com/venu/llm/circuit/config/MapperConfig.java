package com.venu.llm.circuit.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to provide the ModelMapper bean. ModelMapper is used to
 * map between DTOs (Data Transfer Objects) and POJOs (Plain Old Java Objects) /
 * Domain Models.
 */

@Configuration
public class MapperConfig {

	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return new ModelMapper();
	}

}
