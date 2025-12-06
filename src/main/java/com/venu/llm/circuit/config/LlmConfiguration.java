//package com.venu.llm.circuit.config;
//
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.ai.openai.OpenAiChatOptions;
//import org.springframework.ai.openai.api.OpenAiApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestClient;
//
//import com.venu.llm.circuit.properties.LlmProperties;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class LlmConfiguration {
//	
//	private final LlmProperties llmProperties;
//	
//	@Bean
//	OpenAiApi openAiApi() {
//		if(!llmProperties.getOpenai().isEnabled()) {
//			log.warn("Open Ai disabled");
//			return null;
//		}
//		
//		return new OpenAiApi(llmProperties.getOpenai().getApiUrl(), llmProperties.getOpenai().getApiKey());
//	}
//	
//	@Bean
//    public OpenAiChatModel openAiChatModel(OpenAiApi openAiApi) {
//        if (openAiApi == null) {
//            return null;
//        }
//        
//        OpenAiChatOptions options = OpenAiChatOptions.builder()
//                .model(llmProperties.getOpenai().getModel())
//                .temperature(llmProperties.getOpenai().getTemperature())	
//                .maxTokens(llmProperties.getOpenai().getMaxTokens())
//                .build();
//        
//        return new OpenAiChatModel(openAiApi, options);
//    }
//	
//	@Bean
//    RestClient restClient() {
//        return RestClient.builder()
//                .build();
//    }
//}
