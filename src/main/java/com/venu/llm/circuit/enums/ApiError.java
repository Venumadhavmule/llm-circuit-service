package com.venu.llm.circuit.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * Enum for standardizing API error responses.
 * This is used by our custom exceptions and the global handler
 * to provide consistent, meaningful error messages.
 */

@Getter
@RequiredArgsConstructor
public enum ApiError {
	
    // --- 4xx Client Errors ---
	BAD_REQUEST(HttpStatus.BAD_REQUEST,"Invalid request parameters"),
	VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"Validation failed for request"),
	MODEL_NOT_FOUND(HttpStatus.BAD_REQUEST,"The requested LLM model is not supported"),
	
	
    // --- 5xx Server Errors ---
	LLM_SERVICE_ERROR(HttpStatus.SERVICE_UNAVAILABLE,"Error communicating with the LLM provider"),
	INTERNAL_SERVICE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"An unexpected internal error occurred");
	
	private ApiError(HttpStatus httpStatus,String defaultMessage) {
	}
}
