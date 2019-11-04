package com.learn.fantasy.dto.request;

import java.io.Serializable;

/**
 * Created by stepanferubko
 */
public class AbstractResponse implements Serializable {
    protected boolean error;
    protected String errorCode;
    protected String errorMessage;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static AbstractResponse successResponse() {
        return new AbstractResponse();
    }

    public static AbstractResponse errorResponse(String errorCode, String errorMessage) {
        return FaultResponseFactory.errorResponse(new AbstractResponse(), errorCode, errorMessage);
    }
}
