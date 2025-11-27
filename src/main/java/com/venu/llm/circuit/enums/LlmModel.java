package com.venu.llm.circuit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LlmModel {

	GEMINI_1_5_FLASH("gemini-1.5-flash"),
	GEMINI_1_5_PRO("gemini-1.5-pro");

	private LlmModel(String modelName) {}

}
