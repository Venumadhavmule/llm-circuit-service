package com.venu.llm.circuit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venu.llm.circuit.dto.request.LlmRequestDTO;
import com.venu.llm.circuit.dto.request.LlmResponseDTO;
import com.venu.llm.circuit.service.LlmService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/llm")
//@RequiredArgsConstructor
public class LlmController {
	
    private final LlmService llmService;
    
    public LlmController(LlmService llmService) {
    	this.llmService = llmService;
    }
	
	public ResponseEntity<LlmResponseDTO> handleQuery(@Valid @RequestBody LlmRequestDTO request){
		LlmResponseDTO response = llmService.queryModel(request);
		return ResponseEntity.ok(response);
	}
}
