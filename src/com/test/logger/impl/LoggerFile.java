package com.test.logger.impl;

import com.test.logger.LoggerResource;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author marcos
 * @date 7/11/19
 */

public class LoggerFile implements LoggerResource {


    @Override
    public void logMessage(String messageText,Map params, Logger logger) throws IOException {
        String fileName = params.get("logFileFolder") + "/logFile.txt";
        File logFile = new File(fileName);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        FileHandler fh = new FileHandler(fileName);
        logger.addHandler(fh);
        logger.log(Level.INFO, messageText);
    }
}
