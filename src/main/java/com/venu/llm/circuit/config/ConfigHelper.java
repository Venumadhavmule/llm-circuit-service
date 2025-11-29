package com.venu.llm.circuit.config;

import org.springframework.ai.model.chat.client.autoconfigure.ChatClientBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigHelper {

	@Bean
	ChatClientBuilderConfigurer chatClientBuilderConfigurer() {
		return new ChatClientBuilderConfigurer();
	}
}
