package com.venu.llm.circuit.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.venu.llm.circuit.enums.LlmModel;
import com.venu.llm.circuit.provider.LlmProvider;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LlmProviderFactory {

	@Qualifier("geminiLlmProvider")
	private final LlmProvider geminiProvider;

	// We could add another provider here:
	// @Qualifier("openAiLlmProvider")
	// private final LlmProvider openAiProvider;

	/**
	 * The "factory method" that returns the correct provider.
	 * 
	 * @param model The enum of the model to be used.
	 * @return The corresponding LlmProvider implementation.
	 */

	public LlmProvider getProvider(LlmModel model) {
		switch (model) {
		case GEMINI_1_5_FLASH, GEMINI_1_5_PRO:
			return geminiProvider;

		default:
			throw new IllegalArgumentException("Unsupported model: " + model);
		}
	}
}
