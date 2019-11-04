package com.learn.fantasy.exception;

import com.learn.fantasy.dto.request.AbstractResponse;
import com.learn.fantasy.util.ErrorCodes;

/**
 * Created by stepanferubko
 */
public class InternalServiceInvocationException extends Exception {
    private String errorCode;
    private String errorMessage;

    public InternalServiceInvocationException(String errorCode, String errorMessage) {
        super(String.format("code='%s' message='%s'", errorCode, errorMessage));
        this.errorCode = errorCode == null ? ErrorCodes.UNEXPECTED_ERROR : errorCode;
        this.errorMessage = errorMessage;
    }

    public InternalServiceInvocationException(AbstractResponse response) {
        this(response.getErrorCode(), response.getErrorMessage());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}