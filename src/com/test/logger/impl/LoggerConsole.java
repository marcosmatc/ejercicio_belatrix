package com.test.logger.impl;

import com.test.logger.LoggerResource;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author marcos
 * @date 7/11/19
 */
public class LoggerConsole implements LoggerResource {

    @Override
    public void logMessage(String messageText, Map params, Logger logger) {
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(Level.INFO, messageText);
    }
}
