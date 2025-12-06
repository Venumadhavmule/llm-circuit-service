package com.venu.llm.circuit.dto.request;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LlmRequestDto {

	@NotBlank(message = "Prompt cannot be blank")
	@Size(min = 1, max = 10000, message = "Prompt must be between 1 and 10000 characters")
	private String prompt;

	
	@NotBlank(message = "Model name is required")
	private String modelName;

	private Double temperature;

	private Integer maxTokens;

	private Map additionalParameters;

	private String conversationId;

	private Boolean stream;

}
