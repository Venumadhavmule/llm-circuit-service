package com.venu.llm.circuit.dto.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;

/**
 * A standard DTO for sending consistent error responses to the client. This is
 * used by the GlobalExceptionHandler.
 */

@Data
public class ErrorResponseDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime timestamp;

	private int status;
	private String error;
	private String message;
	private String path;

	public ErrorResponseDTO(int status, String error, String message, String path) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

}
