package com.test.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public interface LoggerResource {

    void logMessage(String messageText, Map params, Logger logger) throws Exception;

    static void logToDatabase(Map dbParams, boolean message, int t) throws Exception{
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));
        PreparedStatement stmt = null;

        String insert  = "insert into Log_Values(?, ?)";

        try{
            connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
                    + ":" + dbParams.get("portNumber") + "/", connectionProps);

            stmt = connection.prepareStatement(insert);

            stmt.setString(1, String.valueOf(message));
            stmt.setString(2, String.valueOf(t));

            stmt.executeUpdate();

        }catch (SQLException ex){
            throw ex;
        }finally {
            if(stmt!=null && !stmt.isClosed()){
                stmt.close();
            }
            if(connection!=null && !connection.isClosed()){
                connection.close();
            }
        }
    }

}
