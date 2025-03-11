package com.pepinho.ad.jpa.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PepinhoLogger {

    public static PepinhoLogger LOG = PepinhoLogger.getInstance();

    private static PepinhoLogger instance;

    private final Logger log = LoggerFactory.getLogger(PepinhoLogger.class);

    private PepinhoLogger() {
    }

    public static PepinhoLogger getInstance() {
        if(instance == null) {
            synchronized (PepinhoLogger.class) {
                if(instance == null) {
                    instance = new PepinhoLogger();
                }
            }
        }
        return instance;
    }

    public void error(String message) {
        log.error(message);
    }

    public void info(String message) {
        log.info(message);
    }

    public void warn(String message) {
        log.warn(message);
    }

    public void debug(String message) {
        log.debug(message);
    }

    public void trace(String message) {
        log.trace(message);
    }

    public void error(String message, Throwable t) {
        log.error(message, t);
    }

    public void info(String message, Throwable t) {
        log.info(message, t);
    }

}
