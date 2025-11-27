package com.venu.llm.circuit.model;

import com.venu.llm.circuit.enums.LlmModel;

import lombok.Data;


/**
 * POJO (Plain Old Java Object) or "Domain Model".
 * This represents the query within our business logic layer.
 * We map the LlmRequest DTO to this class using ModelMapper
 * to separate our internal logic from the external API contract.
 */

@Data
public class Query {

	private String prompt;
	private LlmModel llmModel;
}
