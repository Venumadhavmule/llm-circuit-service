package com.venu.llm.circuit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RestClientConfiguration {

	/**
	 * Creates and configures ObjectMapper bean.
	 */
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();

		// Register Java 8 date/time module
		mapper.registerModule(new JavaTimeModule());

		// Disable writing dates as timestamps
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		// Pretty print
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Don't fail on unknown properties
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return mapper;
	}
}
