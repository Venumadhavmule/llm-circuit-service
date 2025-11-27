package com.venu.llm.circuit.service;

import org.springframework.stereotype.Service;

import com.venu.llm.circuit.dto.request.LlmRequestDTO;
import com.venu.llm.circuit.dto.request.LlmResponseDTO;


/**
 * Interface for the LlmService.
 * This defines the contract for our business logic layer,
 * decoupling the Controller from the implementation.
 */
@Service
public interface LlmService {
	
	/**
     * Orchestrates the logic to query an LLM.
     * @param request The incoming request DTO.
     * @return The outgoing response DTO.
     */
	LlmResponseDTO queryModel(LlmRequestDTO request);
}
