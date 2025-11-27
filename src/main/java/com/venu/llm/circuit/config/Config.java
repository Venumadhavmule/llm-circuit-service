package com.venu.llm.circuit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.genai.Client;

import java.lang.module.ModuleDescriptor.Builder;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class Config {

//	@Bean
//	public Client genAiClient() {
//		return new Client().builder().apiKey(@Value("${spring.ai.google.genai.api-key}") String apiKey).Builder();
//	}
}
