package com.venu.llm.circuit.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.model.chat.client.autoconfigure.ChatClientBuilderConfigurer;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LlmClientsConfig {

	@Bean
	ChatClient geminiChatClient(GoogleGenAiChatModel googleChatAiChatModel, ChatClientBuilderConfigurer configurer) {
		
		ChatClient.Builder builder = ChatClient.builder(googleChatAiChatModel);

		return configurer.configure(builder).build();
	}
	
	@Bean
	ChatClient openAiChatClient(OpenAiChatModel openAiChatModel, ChatClientBuilderConfigurer configurer) {

		ChatClient.Builder builder = ChatClient.builder(openAiChatModel);

		return configurer.configure(builder).build();
	}
}
