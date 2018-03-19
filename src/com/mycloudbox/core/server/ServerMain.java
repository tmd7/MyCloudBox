package com.mycloudbox.core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server has started... Waiting clients...");
            Socket socket = serverSocket.accept();
            System.out.println("Client has connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //Test: echo from server
            while (true) {
                String msg = in.readUTF();
                System.out.println("from client: " + msg);
                out.writeUTF("echo: " + msg);
                if (msg.equals("/end")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}