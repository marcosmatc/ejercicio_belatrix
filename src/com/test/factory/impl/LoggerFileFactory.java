package com.test.factory.impl;

import com.test.logger.impl.LoggerFile;
import com.test.logger.LoggerResource;
import com.test.factory.LoggerFactory;

public class LoggerFileFactory implements LoggerFactory {

    private LoggerResource loggerResource;

    @Override
    public LoggerResource getLogger() {

        if(loggerResource==null){
            loggerResource = new LoggerFile();
        }

        return loggerResource;
    }

}
