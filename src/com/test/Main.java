package com.test;

import com.test.dto.LoggerParams;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author marcos
 * @date 7/11/19
 */
public class Main {

    public static void main(String[] args) {

        try {
            LoggerParams loggerParams = new LoggerParams();
            Map<String,String> dbParams = new HashMap<>();
            dbParams.put("logFileFolder","/home/marcos/");
            loggerParams.setDbParams(dbParams);
            loggerParams.setLogger(Logger.getLogger("MyLog"));
            loggerParams.setLogToFile(true);
            loggerParams.setLogError(true);
            loggerParams.setLogMessage(true);
            loggerParams.setLogToConsole(true);
            loggerParams.setLogToConsole(true);
            JobLogger jobLogger = new JobLogger(loggerParams);
            jobLogger.logMessage("Hola Mundo",true,true,true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
