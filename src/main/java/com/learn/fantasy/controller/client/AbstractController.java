package com.learn.fantasy.controller.client;

import com.learn.fantasy.dto.request.AbstractResponse;
import com.learn.fantasy.dto.request.FaultResponseFactory;
import com.learn.fantasy.exception.InternalServiceInvocationException;
import com.learn.fantasy.util.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.learn.fantasy.util.ErrorCodes.ILLEGAL_ARGUMENTS;

/**
 * Created by stepanferubko
 */
public class AbstractController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractController.class);
    private static final String DEFAULT_ERR_CODE = ErrorCodes.UNEXPECTED_ERROR;

    protected <T extends AbstractResponse> T callRemote(RemoteClientFunction<T> function, Supplier<T> errorWrapper) {
        try {
            return function.call();
        } catch (InternalServiceInvocationException e) {
            LOG.error("Remote action error", e);
            T err = errorWrapper.get();
            return FaultResponseFactory.errorResponse(err, e);
        } catch (Throwable th) {
            LOG.error("Remote action error", th);
            T err = errorWrapper.get();
            return FaultResponseFactory.errorResponse(err, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public interface RemoteClientFunction<R> {
        R call() throws InternalServiceInvocationException;
    }

    <T extends AbstractResponse> T catchApiError(T instance, FaultResponseFactory.InternalFunction<T, T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        T resp;
        try {
            resp = serviceFunction.apply(instance);
        } catch (InternalServiceInvocationException th) {
            customErrorProcessor.accept(th);
            resp = FaultResponseFactory.errorResponse(instance, th);
        } catch (HttpClientErrorException th) {
            if (th.getRawStatusCode() == 401) {
                throw th;
            }
            String code = th.getRawStatusCode() == 403 ? ErrorCodes.ACCESS_DENIED : DEFAULT_ERR_CODE;
            resp = acceptError(instance, customErrorProcessor, th, code);
        } catch (Throwable th) {
            resp = acceptError(instance, customErrorProcessor, th, DEFAULT_ERR_CODE);
        }
        return resp;
    }

    protected <T extends AbstractResponse> T catchBusinessMethodException(T instance, EntityNotFoundExceptionRiskGeneratorFunc<T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instance);
//        } catch (Exception e) {
//            customErrorProcessor.accept(e);
//            return FaultResponseFactory.notFoundErrorResponse(instance, e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            customErrorProcessor.accept(e);
            return FaultResponseFactory.errorResponse(instance, ILLEGAL_ARGUMENTS, e.getMessage());
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return FaultResponseFactory.errorResponse(instance, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    private <T extends AbstractResponse> T acceptError(T instance, Consumer<Throwable> customErrorProcessor, Throwable th, String code) {
        customErrorProcessor.accept(th);
        return FaultResponseFactory.errorResponse(instance, code, th.getMessage());
    }

    public interface EntityNotFoundExceptionRiskGeneratorFunc<T extends AbstractResponse> {
        T apply(T initialResponse) throws Exception;
    }
}
