package com.learn.fantasy.util;

/**
 * Created by stepanferubko
 */
public abstract class ErrorCodes {
    public static final String FILE_NOT_FOUND = "ENTITY_NOT_FOUND";
    public static final String NOT_READY = "NOT_READY";
    public static final String ACCESS_DENIED = "ACCESS_DENIED";
    public static final String UNEXPECTED_ERROR = "UNEXPECTED_ERROR";
    public static final String IMAGE_WARNING = "IMAGE_WARNING";
    public static final String ILLEGAL_ARGUMENTS = "ILLEGAL_ARGUMENTS";

    public static String generateErrorId(String source) {
        long time = System.currentTimeMillis();
        return source + time;
    }
}
