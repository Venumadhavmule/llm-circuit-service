package com.venu.llm.circuit.service.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.venu.llm.circuit.service.LlmService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenAiServiceImplementation implements LlmService {

	private ChatClient openChatClient;

	public OpenAiServiceImplementation(@Qualifier("openAiChatClient") ChatClient openChatClient) {
		this.openChatClient = openChatClient;
	}

	@Override
	public String sendTextQuery(String prompt) {

		log.info("Open ai llm Query is placed: {}", prompt);

		String result = openChatClient.prompt().user(prompt).call().content();
		
		log.info("Open Ai llm response get successfully");

		return result;
	}

}
