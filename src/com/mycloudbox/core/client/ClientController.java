package com.mycloudbox.core.client;

import javafx.fxml.Initializable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable{
    private Connection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = new Connection();
        connection.connect();
    }


}
