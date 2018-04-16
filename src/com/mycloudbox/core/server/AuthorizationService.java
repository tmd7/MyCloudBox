package com.mycloudbox.core.server;

import java.sql.*;

public class AuthorizationService {
    private Connection connection;
    private PreparedStatement pst;
    private Statement statement;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:com/mycloudbox/core/server/data/mycloudbox.db");
        //pst = connection.prepareStatement("");
        statement = connection.createStatement();
    }

    public boolean ifLoaginAndPasOk(String login, String pas) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE login='" + login + "' AND pas='"+ pas +"';");
            //if the resultSet has a line, it will return true. The ResultSet can't has more than once line, because the login has unic a value.
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void disconnect() throws SQLException {
        statement.close();
        connection.close();
    }
}
