package com.venu.llm.circuit.provider;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;

/**
 * Interface for an LLM provider.
 * This abstracts the underlying implementation (Gemini, OpenAI, etc.)
 * from our service layer.
 */

public interface LlmProvider {
	
	/**
     * Generates a response from the LLM.
     * @param prompt The Spring AI Prompt object.
     * @return The Spring AI ChatResponse object.
     */
	ChatResponse generate(Prompt prompt);

}
