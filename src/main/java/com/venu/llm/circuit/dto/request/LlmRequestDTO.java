package com.venu.llm.circuit.dto.request;

import com.venu.llm.circuit.enums.LlmModel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LlmRequestDTO {
	
	@NotBlank(message = "Prompt cannot be null")
	private String prompt;
	
	@NotBlank(message = "Model cannot be null. Please specify a model")
	private LlmModel model;
}
