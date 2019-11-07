package com.test;

import com.test.dto.LoggerParams;
import com.test.dto.MessageLevel;
import com.test.factory.LoggerFactory;
import com.test.factory.impl.LoggerConsoleFactory;
import com.test.factory.impl.LoggerFileFactory;
import com.test.logger.LoggerResource;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author marcos
 * @date 7/11/19
 */
public class JobLogger {

    private LoggerParams loggerParams;

    private static LoggerFactory factoryLoggerFile = new LoggerFileFactory();
    private static LoggerFactory factoryLoggerConsole = new LoggerConsoleFactory();

    public LoggerParams getLoggerParams() {
        return loggerParams;
    }

    private JobLogger() {

    }

    public JobLogger(LoggerParams loggerParams) {
        this.loggerParams = loggerParams;
    }

    private MessageLevel bluidMessage(String messageText, boolean message, boolean warning, boolean error){
        MessageLevel messageLevel =  new MessageLevel();

        StringBuilder messageSB = new StringBuilder();
        int level = 0;

        if (message && getLoggerParams().isLogMessage()) {
            level = 1;
            messageSB.append("message ")
                    .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
                    .append(messageText);
        }

        if (error && getLoggerParams().isLogError()) {
            level = 2;
            messageSB.append("error ")
                    .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
                    .append(messageText);
        }

        if (warning && getLoggerParams().isLogWarning()) {
            level = 3;
            messageSB.append("warning ")
                    .append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
                    .append(messageText);
        }

        messageLevel.setLevel(level);
        messageLevel.setMessage(messageSB.toString());

        return messageLevel;
    }

    public void logMessage( String messageText, boolean message, boolean warning, boolean error) throws Exception {

        messageText =  messageText.trim();

        MessageLevel messageLevel = bluidMessage(messageText,message,warning,error);
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!getLoggerParams().isLogToConsole() && !getLoggerParams().isLogToFile() && !getLoggerParams().isLogToDatabase()) {
            throw new Exception("Invalid configuration");
        }
        if ((!getLoggerParams().isLogError() && !getLoggerParams().isLogMessage() && !getLoggerParams().isLogWarning()) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }

        if(getLoggerParams().isLogToDatabase()) {
            LoggerResource.logToDatabase(getLoggerParams().getDbParams(),message,messageLevel.getLevel());

        }

        if(getLoggerParams().isLogToFile()) {
            factoryLoggerFile.getLogger().logMessage(messageLevel.getMessage(),getLoggerParams().getDbParams(),getLoggerParams().getLogger());

        }

        if(getLoggerParams().isLogToConsole()) {
            factoryLoggerConsole.getLogger().logMessage(messageLevel.getMessage(),getLoggerParams().getDbParams(),getLoggerParams().getLogger());
        }


    }
}
