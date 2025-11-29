package com.venu.llm.circuit.dto;

import java.time.Instant;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LlmLogEntry {
	String event;
	String prompt;
	String response;
	Map<String, Object> metadata;
	Instant timestamp;
}
