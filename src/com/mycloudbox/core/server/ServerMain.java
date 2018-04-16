package com.mycloudbox.core.server;

import java.sql.SQLException;

public class ServerMain {
    //Stop video 3:48 lesson07 17.04.2018
    private static Connect connection;
    private static AuthorizationService authSer;

    public static void main(String[] args) {
        //create socket connection
        connection = new Connect();
        connection.connect();

        //create db connection
        try {
            authSer = new AuthorizationService();
            authSer.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Authorization service hasn't run");
        } finally {
            try {
                authSer.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
