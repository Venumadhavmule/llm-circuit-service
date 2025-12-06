package com.venu.llm.circuit.exception;

import okhttp3.internal.http2.ErrorCode;

/**
 * Exception thrown when request validation fails.
 */
public class InvalidRequestException extends LlmServiceException {
    
    public InvalidRequestException(ErrorCode errorCode, String details) {
        super(errorCode, details);
    }
}