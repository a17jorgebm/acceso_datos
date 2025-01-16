package com.pepinho.ad.biblioteca.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BibliotecaLogger {

    public static BibliotecaLogger LOG = BibliotecaLogger.getInstance();

    private static BibliotecaLogger instance;

    private final Logger log = LoggerFactory.getLogger(BibliotecaConnectionMaganer.class);

    private BibliotecaLogger() {
    }

    public static BibliotecaLogger getInstance() {
        if(instance == null) {
            synchronized (BibliotecaLogger.class) {
                if(instance == null) {
                    instance = new BibliotecaLogger();
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
