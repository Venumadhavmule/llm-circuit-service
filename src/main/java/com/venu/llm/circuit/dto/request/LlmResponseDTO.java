package com.venu.llm.circuit.dto.request;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Data Transfer Object (DTO) for outgoing LLM responses.
 * This defines the "response format" we send back to the client.
 */

@Getter
@AllArgsConstructor
public class LlmResponseDTO {
	
	private String content;
	private Map<String, Object> metadata;
}
