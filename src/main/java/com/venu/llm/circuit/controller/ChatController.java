package com.venu.llm.circuit.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venu.llm.circuit.service.GeminiService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/llm-circuit")
@Slf4j
@AllArgsConstructor
public class ChatController {

	private GeminiService geminiService;
	
	

	@PostMapping("/chat")
	public String generateText(@RequestBody Map<String, String> body) {

		log.info("At ChatController GeminService calling Prompt: {}",body);

		String prompt = body.get("prompt");
		String result = geminiService.sendTextQuery(prompt);
		
		log.info("At ChatController {} the llm response: ", result);

		return result;

	}

}
