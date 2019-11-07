package com.test.dto;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author marcos
 * @date 7/11/19
 */
public class LoggerParams {
    private boolean logToFile;
    private boolean logToConsole;
    private boolean logMessage;
    private boolean logWarning;
    private boolean logError;
    private boolean logToDatabase;
    private Map dbParams;
    private Logger logger;

    public boolean isLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public void setLogToConsole(boolean logToConsole) {
        this.logToConsole = logToConsole;
    }

    public boolean isLogMessage() {
        return logMessage;
    }

    public void setLogMessage(boolean logMessage) {
        this.logMessage = logMessage;
    }

    public boolean isLogWarning() {
        return logWarning;
    }

    public void setLogWarning(boolean logWarning) {
        this.logWarning = logWarning;
    }

    public boolean isLogError() {
        return logError;
    }

    public void setLogError(boolean logError) {
        this.logError = logError;
    }

    public boolean isLogToDatabase() {
        return logToDatabase;
    }

    public void setLogToDatabase(boolean logToDatabase) {
        this.logToDatabase = logToDatabase;
    }

    public Map getDbParams() {
        return dbParams;
    }

    public void setDbParams(Map dbParams) {
        this.dbParams = dbParams;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
