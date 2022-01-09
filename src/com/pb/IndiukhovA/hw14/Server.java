package com.pb.IndiukhovA.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String myTime;

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
            {
                System.out.println("Connection new Client");

                String clientMessage;
                System.out.println("wait messages");
                while ((clientMessage = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    myTime = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss").format(Calendar.getInstance().getTime());
                    out.println("Server answer " + myTime + ": " + clientMessage);
                    System.out.println(clientMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException exep) {
                    exep.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {

        int serverPort = 1777;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server started");
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
