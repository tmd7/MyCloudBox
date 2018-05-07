package com.mycloudbox.core.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect {

    public void connect() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Server has started... Waiting clients...");

            //multi connection
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client has connected");
                new ClientHandler(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
