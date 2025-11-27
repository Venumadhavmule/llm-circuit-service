package com.venu.llm.circuit.provider.impl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.venu.llm.circuit.provider.LlmProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("geminiLlmProvider")
@RequiredArgsConstructor
public class GeminiLlmProvider implements LlmProvider {
	
	private ChatClient chatClient;
	
	@Override
	public ChatResponse generate(Prompt prompt) {
		
		return (ChatResponse) chatClient.prompt(prompt);
	}

}
