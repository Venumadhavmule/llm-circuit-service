package com.venu.llm.circuit.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/llm-circuit")
@Slf4j
public class ChatController {

	private final ChatClient chatClient;

	public ChatController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@PostMapping("/chat")
	public String generateText(
			@RequestParam(defaultValue = "Let me know top 5 best technologies of 2026 gradutate without any markdown beautification and give me bullet points wise and sections wise.. that too must be beatable and explain me in eli5\"") String prompt) {
		log.info("Request recieved for generateText: {}", prompt);

		String result = chatClient.prompt().user(prompt).call().content();

		return result;

	}

}
