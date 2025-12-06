package com.venu.llm.circuit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LlmProviderEnum {
//	OPENAI("openai", "OpenAI GPT Models", "gpt-4"),
	GEMINI("gemini", "Google Gemini", "gemini-pro");

	private final String code;
	private final String displayName;
	private final String defualtModel;

	public static LlmProviderEnum fromCode(String code) {
		for (LlmProviderEnum provider : values()) {
			if (provider.getCode().equalsIgnoreCase(code)) {
				return provider;
			}
		}

		throw new IllegalArgumentException("Unkown LLM Provider: " + code);
	}

	public static LlmProviderEnum fronModelName(String modelName) {
		String lowerModel = modelName.toLowerCase();
		if (lowerModel.contains("gemini") || lowerModel.contains("google")) {
			return GEMINI;
		}
		throw new IllegalArgumentException("Cannot determine provider from model: " + modelName);
	}
}
