package com.learn.fantasy.dto.request;

import com.learn.fantasy.exception.InternalServiceInvocationException;
import com.learn.fantasy.util.ErrorCodes;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Created by stepanferubko
 */
public class FaultResponseFactory {
    public static <T extends AbstractResponse> T errorResponse(T instance, String errorCode, String errorMessage) {
        instance.setError(true);
        instance.setErrorCode(errorCode);
        instance.setErrorMessage(errorMessage);
        return instance;
    }

    public static <T extends AbstractResponse> T errorResponse(T instance, InternalServiceInvocationException e) {
        instance.setError(true);
        instance.setErrorCode(e.getErrorCode());
        instance.setErrorMessage(e.getErrorMessage());
        return instance;
    }

    public static <T extends AbstractResponse> T notFoundErrorResponse(T instance, String errorMessage) {
        return errorResponse(instance, ErrorCodes.FILE_NOT_FOUND, errorMessage);
    }

    public static <T extends AbstractResponse> T catchServiceError(Supplier<T> instanceSupl, Function<Supplier<T>, T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instanceSupl);
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return errorResponse(instanceSupl.get(), ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public static <T extends AbstractResponse> T catchServiceError(T instance, UnaryOperator<T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instance);
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return errorResponse(instance, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public static <T extends AbstractResponse> T catchInternalError(T instance, InternalFunction<T, T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instance);
        } catch (InternalServiceInvocationException th) {
            customErrorProcessor.accept(th);
            return errorResponse(instance, th);
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return errorResponse(instance, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public static String unexpectedErrorMessage(String actionName, boolean addId) {
        return addId
                ? String.format("An unexpected error occurred: id='%s' operation='%s'", ErrorCodes.generateErrorId("ERR_"), actionName)
                : String.format("An unexpected error occurred: operation='%s'", actionName);
    }

    public interface InternalFunction<T, R> {
        /**
         * Applies this function to the given argument.
         *
         * @param t the function argument
         * @return the function result
         */
        R apply(T t) throws InternalServiceInvocationException;
    }
}
