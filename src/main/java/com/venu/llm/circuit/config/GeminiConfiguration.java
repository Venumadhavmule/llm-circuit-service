package com.venu.llm.circuit.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import com.venu.llm.circuit.properties.LlmProperties;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@AllArgsConstructor
public class GeminiConfiguration {

	private final LlmProperties llmProperties;

	@Bean
	@ConditionalOnProperty(prefix = "llm.gemini", name = "enabled", havingValue = "true", matchIfMissing = true)
	public RestClient geminiRestClient() {

		log.info("Intialising Gemini RestClient with the base URL: {}", llmProperties.getGemini().getApiUrl());

		if (llmProperties.getGemini().getApiKey() == null || llmProperties.getGemini().getApiKey().isEmpty()
				|| llmProperties.getGemini().getApiKey().equals("your-gemini-api-key-here")) {
			log.warn("Gemini API key is not properly configured! Service may not work correctly.");
		}

		return RestClient.builder().baseUrl(llmProperties.getGemini().getApiUrl())
				.requestFactory(geminiClientHttpRequestFactory()).build();
	}

	/**
	 * Creates HTTP request factory with custom timeout settings for Gemini.
	 */
	@Bean
	public ClientHttpRequestFactory geminiClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(Duration.ofMillis(llmProperties.getGemini().getTimeout()));
		factory.setReadTimeout(Duration.ofMillis(llmProperties.getGemini().getTimeout()));

		log.debug("Gemini HTTP factory configured with timeout: {}ms", llmProperties.getGemini().getTimeout());

		return factory;
	}
}
