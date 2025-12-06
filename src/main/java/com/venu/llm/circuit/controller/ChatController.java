//package com.venu.llm.circuit.controller;
//
//import java.util.Map;
//
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.venu.llm.circuit.service.LlmService;
//import com.venu.llm.circuit.service.ServiceRetrieverFactory;
//
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Flux;
//
//@RestController
//@RequestMapping("/api/v1/llm-circuit")
//@Slf4j
//public class ChatController {
//
////	private ServiceRetrieverFactory serviceFactory;
////	
////	public ChatController(ServiceRetrieverFactory serviceRetrieverFactory) {
////		this.serviceFactory = serviceRetrieverFactory;
////	}
//
//	@PostMapping("/generate-chat")
//	public ResponseEntity<Map<String, String>> generateText(@RequestBody Map<String, String> body) {
//
//		log.info("At ChatController GeminService calling Prompt: {}", body);
//
//		String prompt = body.get("prompt");
//
////		LlmService implemetedModel = serviceFactory.getRetriver("OPENAI");
//
////		String result = implemetedModel.sendTextQuery(prompt);
//
////		log.info("At ChatController {} the llm response: ", result);
////
////		return org.springframework.http.ResponseEntity.ok(Map.of("output", result));
//
//	}
//
//	@PostMapping(value = "/generate-chat-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Flux<String> generateTextStream(@RequestBody Map<String, String> body) {
//		String prompt = body.get("prompt");
//		LlmService implemetedModel = serviceFactory.getRetriver("OPENAI");
//
//		return implemetedModel.streamTextQuery(prompt);
//	}
//
//}
