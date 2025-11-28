package com.venu.llm.circuit.service;

import javax.management.RuntimeErrorException;

import reactor.core.publisher.Flux;

public interface LlmService {

	public String sendTextQuery(String prompt);

	default public Flux<String> streamTextQuery(String prompt) {
		throw new RuntimeErrorException(new Error("Runtime blew up"), prompt);

	}
}
