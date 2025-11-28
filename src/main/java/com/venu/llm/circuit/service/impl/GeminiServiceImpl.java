package com.venu.llm.circuit.service.impl
;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.google.genai.ResponseStream;
import com.google.genai.types.GenerateContentResponse;
import com.venu.llm.circuit.service.LlmService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class GeminiServiceImpl implements LlmService {

	private ChatClient chatClient;

	public GeminiServiceImpl(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	public String sendTextQuery(String prompt) {
		log.info("Getting the request: {}", prompt);

		String result = chatClient.prompt().user(prompt).call().content();

		log.info("Returning the response: {}", result);
		return result;
	}

	public Flux<String> streamTextQuery(String prompt) {
		log.info("Starting streaming call for prompt: {}", prompt);

		return chatClient.prompt().user(prompt).stream().content();
	}

}
