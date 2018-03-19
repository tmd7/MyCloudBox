package com.mycloudbox.core.client;

import javafx.fxml.Initializable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable{
    private final String SERVER_IP = "localhost";
    private final int SERVER_PORT = 8888;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Client has connected...");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = in.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
