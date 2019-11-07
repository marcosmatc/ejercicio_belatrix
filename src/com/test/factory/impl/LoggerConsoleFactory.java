package com.test.factory.impl;

import com.test.logger.impl.LoggerConsole;
import com.test.logger.LoggerResource;
import com.test.factory.LoggerFactory;

/**
 * @author marcos
 * @date 7/11/19
 */
public class LoggerConsoleFactory implements LoggerFactory {

    private LoggerResource loggerResource;

    @Override
    public LoggerResource getLogger() {

        if(loggerResource==null){
            loggerResource = new LoggerConsole();
        }

        return loggerResource;
    }
}
