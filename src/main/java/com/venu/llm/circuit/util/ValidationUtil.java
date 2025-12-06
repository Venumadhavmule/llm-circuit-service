package com.venu.llm.circuit.util;

/**
 * Utility class for request validation.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ValidationUtil {
    
    private final LlmProperties llmProperties;
    
    /**
     * Validates LLM request.
     */
    public void validateRequest(LlmRequestDto request) {
        log.debug("Validating request for model: {}", request.getModelName());
        
        // Validate prompt
        validatePrompt(request.getPrompt());
        
        // Validate model name
        validateModelName(request.getModelName());
        
        // Validate temperature
        if (request.getTemperature() != null) {
            validateTemperature(request.getTemperature());
        }
        
        // Validate max tokens
        if (request.getMaxTokens() != null) {
            validateMaxTokens(request.getMaxTokens());
        }
        
        log.debug("Request validation successful");
    }
    
    private void validatePrompt(String prompt) {
        if (StringUtils.isBlank(prompt)) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_FIELD,
                    "Prompt is required and cannot be blank"
            );
        }
        
        int promptLength = prompt.length();
        int maxLength = llmProperties.getValidation().getMaxPromptLength();
        int minLength = llmProperties.getValidation().getMinPromptLength();
        
        if (promptLength > maxLength) {
            throw new InvalidRequestException(
                    ErrorCode.PROMPT_TOO_LONG,
                    String.format("Prompt length (%d) exceeds maximum allowed length (%d)", 
                            promptLength, maxLength)
            );
        }
        
        if (promptLength < minLength) {
            throw new InvalidRequestException(
                    ErrorCode.PROMPT_TOO_SHORT,
                    String.format("Prompt length (%d) is below minimum required length (%d)", 
                            promptLength, minLength)
            );
        }
    }
    
    private void validateModelName(String modelName) {
        if (StringUtils.isBlank(modelName)) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_FIELD,
                    "Model name is required"
            );
        }
    }
    
    private void validateTemperature(Double temperature) {
        if (temperature < 0.0 || temperature > 2.0) {
            throw new InvalidRequestException(
                    ErrorCode.INVALID_TEMPERATURE,
                    String.format("Temperature (%f) must be between 0.0 and 2.0", temperature)
            );
        }
    }
    
    private void validateMaxTokens(Integer maxTokens) {
        if (maxTokens < 1) {
            throw new InvalidRequestException(
                    ErrorCode.INVALID_MAX_TOKENS,
                    String.format("Max tokens (%d) must be greater than 0", maxTokens)
            );
        }
    }
}