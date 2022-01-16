package com.pb.IndiukhovA.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientInterface extends JFrame {
    private final String serverIp = "127.0.0.1";
    private final int serverPort = 1777;
    private Socket server;
    private Scanner inServer;
    private PrintWriter outServer;
    private final JTextField jTextField;
    private final JTextArea jTextArea;



    public ClientInterface() {
        try {
            server = new Socket(serverIp, serverPort);
            inServer = new Scanner(server.getInputStream());
            outServer = new PrintWriter(server.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        setBounds(200, 350, 400, 400);
        setTitle("Echo Server");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);

        JScrollPane jsp = new JScrollPane(jTextArea);
        add(jsp, BorderLayout.CENTER);

        JPanel bottom1 = new JPanel(new BorderLayout());
        add(bottom1, BorderLayout.SOUTH);
        JButton jSendMessage = new JButton("Send message");
        bottom1.add(jSendMessage, BorderLayout.EAST);
        jTextField = new JTextField("Enter your message: ");
        bottom1.add(jTextField, BorderLayout.CENTER);

        jSendMessage.addActionListener(e -> {
            if (!jTextField.getText().trim().isEmpty()) {
                sendMsg();
                jTextField.grabFocus();
            }
        });

        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setText("");
            }
        });


        new Thread(() -> {
            try {
                while (true) {
                    if (inServer.hasNext()) {
                        String inMes = inServer.nextLine();
                        jTextArea.append(inMes);
                        jTextArea.append("\n");

                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outServer.flush();
                    outServer.close();
                    inServer.close();
                    server.close();
                } catch (IOException ee) {
                    System.out.println(ee.getMessage());
                    ee.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String message = jTextField.getText();
        outServer.println(message);
        outServer.flush();
        jTextField.setText("");
    }

}
