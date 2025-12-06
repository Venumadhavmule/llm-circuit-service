package com.venu.llm.circuit.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.venu.llm.circuit.properties.LlmProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Configuration for async processing.
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class AsyncConfiguration {

	private final LlmProperties llmProperties;

	/**
	 * Creates thread pool executor for async LLM operations.
	 */
	@Bean(name = "geminiExecutor")
	public Executor geminiExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(llmProperties.getExecutor().getCorePoolSize());
		executor.setMaxPoolSize(llmProperties.getExecutor().getMaxPoolSize());
		executor.setQueueCapacity(llmProperties.getExecutor().getQueueCapacity());
		executor.setThreadNamePrefix(llmProperties.getExecutor().getThreadNamePrefix());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(60);
		executor.initialize();

		log.info("Gemini thread pool executor initialized with core pool size: {}, max pool size: {}",
				llmProperties.getExecutor().getCorePoolSize(), llmProperties.getExecutor().getMaxPoolSize());

		return executor;
	}
}