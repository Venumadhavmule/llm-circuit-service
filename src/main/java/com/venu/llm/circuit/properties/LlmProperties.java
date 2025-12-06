package com.venu.llm.circuit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("llm")
public class LlmProperties {

//	private OpenAiConfig openai = new OpenAiConfig();
//	private ClaudeConfig claude = new ClaudeConfig();
//	private LlamaConfig llama = new LlamaConfig();
	
	private GeminiConfig gemini = new GeminiConfig();
	private ExecutorConfig executor = new ExecutorConfig();
	private ValidationConfig validation = new ValidationConfig();
	
    
	 @Data
	    public static class GeminiConfig {
	        private boolean enabled = true;
	        private String apiKey;
	        private String apiUrl;
	        private String model;
	        private Double temperature = 0.7;
	        private Integer maxTokens = 2048;
	        private Long timeout = 60000L;
	        private Double topP = 0.95;
	        private Integer topK = 40;
	    }
    
    @Data
    public static class ExecutorConfig {
        private Integer corePoolSize = 10;
        private Integer maxPoolSize = 50;
        private Integer queueCapacity = 100;
        private String threadNamePrefix = "llm-executor-";
    }
    
    @Data
    public static class ValidationConfig {
        private Integer maxPromptLength = 10000;
        private Integer minPromptLength = 1;
    }

}
