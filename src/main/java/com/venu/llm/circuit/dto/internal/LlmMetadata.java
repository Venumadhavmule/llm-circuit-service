package com.venu.llm.circuit.dto.internal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LlmMetadata {
	
	private String provider;
	
	private String model;
	
	private String version;
	
	private Double temperature;
	
	private Integer maxTokens;
}
