package com.venu.llm.circuit.exception;

import com.venu.llm.circuit.enums.ErrorCodeEnum;

import lombok.Getter;
import okhttp3.internal.http2.ErrorCode;

/**
 * Base exception for LLM service errors.
 */
@Getter
public class LlmServiceException extends RuntimeException {
    
    private final ErrorCodeEnum errorCode;
    private final String details;
    
    public LlmServiceException(ErrorCode errorCode, String details) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.details = details;
    }
    
    public LlmServiceException(ErrorCode errorCode, String details, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
        this.details = details;
    }
}