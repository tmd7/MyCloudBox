package com.mycloudbox.core.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private final String SERVER_IP = "localhost";
    private final int SERVER_PORT = 8888;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String clientCommand;

    public void connect() {
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
                            clientCommand = in.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
