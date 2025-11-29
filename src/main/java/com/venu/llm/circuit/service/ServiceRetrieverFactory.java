package com.venu.llm.circuit.service;

import org.springframework.stereotype.Component;

import com.venu.llm.circuit.service.impl.GeminiServiceImpl;
import com.venu.llm.circuit.service.impl.OpenAiServiceImplementation;

@Component
public class ServiceRetrieverFactory {

	private final GeminiServiceImpl geminiService;
	private final OpenAiServiceImplementation openAiService;

	public ServiceRetrieverFactory(GeminiServiceImpl geminiServiceImpl,
			OpenAiServiceImplementation openAiServiceImplementation) {
		this.geminiService = geminiServiceImpl;
		this.openAiService = openAiServiceImplementation;
	}

	public LlmService getRetriver(String llm) {

		switch (llm) {
		case "GEMINI":
			return geminiService;

		case "OPENAI":
			return openAiService;

		default:
			throw new IllegalArgumentException("Not supported Llm model: {}" + llm);
		}

	}
}
