package com.venu.llm.circuit.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GeminiService {

	private ChatClient chatClient;

	public GeminiService(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	public String sendTextQuery(String prompt) {
		log.info("Getting the request: {}", prompt);

		String result = chatClient.prompt().user(prompt).call().content();

		log.info("Returning the response: {}", result);
		return result;
	}

}
