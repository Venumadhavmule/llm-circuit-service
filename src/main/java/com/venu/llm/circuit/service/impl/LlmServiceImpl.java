package com.venu.llm.circuit.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Collections;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.venu.llm.circuit.dto.request.LlmRequestDTO;
import com.venu.llm.circuit.dto.request.LlmResponseDTO;
import com.venu.llm.circuit.factory.LlmProviderFactory;
import com.venu.llm.circuit.model.Query;
import com.venu.llm.circuit.provider.LlmProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class LlmServiceImpl {
	private final LlmProviderFactory providerFactory;
    private final ModelMapper modelMapper;

    @Override
    public LlmResponseDTO queryModel(LlmRequestDTO request) {
        log.info("Processing query for model: {}", request.getModel());

        // 1. Map DTO (LlmRequest) to our internal POJO (Query)
        Query query = modelMapper.map(request, Query.class);

        // 2. Use the Factory to get the correct provider
        LlmProvider provider = providerFactory.getProvider(query.getModel());

        // 3. Build the Spring AI ChatOptions and Prompt
        // This is how we dynamically set the model for the API call
        var chatOptions = ChatOptionsBuilder.builder()
                .withModel(query.getModel().getModelName())
                .build();

        Prompt prompt = new Prompt(query.getPrompt(), chatOptions);

        // 4. Call the Provider to get the response
        ChatResponse aiResponse = provider.generate(prompt);

        // 5. Map the ChatResponse to our LlmResponse DTO
        return mapToLlmResponse(aiResponse);
    }

    /**
     * Helper method to map from Spring AI's ChatResponse
     * to our custom LlmResponse DTO.
     */
    private LlmResponseDTO mapToLlmResponse(ChatResponse aiResponse) {
        Generation generation = aiResponse.getResult();
        if (generation == null) {
            // This would be an unusual error, but good to check
            log.warn("Received empty generation from AI service.");
            return new LlmResponseDTO("No content received.", Collections.emptyMap());
        }

        String content = generation.getOutput().getContent();
        Map<String, Object> metadata = generation.getMetadata().toMap();
        
        return new LlmResponseDTO(content, metadata);
    }

}
