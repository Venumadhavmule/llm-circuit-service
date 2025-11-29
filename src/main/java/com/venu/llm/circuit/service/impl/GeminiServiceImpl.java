package com.venu.llm.circuit.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.venu.llm.circuit.service.LlmService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class GeminiServiceImpl implements LlmService {

	private ChatClient geminiChatClient;

	public GeminiServiceImpl(@Qualifier("geminiChatClient") ChatClient chatClient) {
		this.geminiChatClient = chatClient;
	}

	public String sendTextQuery(String prompt) {
		log.info("Getting the request: {}", prompt);

		String result = geminiChatClient.prompt().user(prompt).call().content();

		log.info("Returning the response: {}", result);
		return result;
	}

	public Flux<String> streamTextQuery(String prompt) {
		log.info("Starting streaming call for prompt: {}", prompt);

		return geminiChatClient.prompt().user(prompt).stream().content();
	}

}
