package com.venu.llm.circuit.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.venu.llm.circuit.dto.internal.LlmMetadata;
import com.venu.llm.circuit.dto.internal.UsageStatistics;
import com.venu.llm.circuit.enums.ResponseStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LlmResponseDto {
	
	private ResponseStatusEnum status;
	
	private String response;
	
	private LlmMetadata metadata;
	
	private UsageStatistics usage;
	
	private Long processingTimeMs;
	
	private String conversationId;
	
	
}
