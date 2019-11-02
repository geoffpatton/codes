package networking.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author general
 *
 *         Chatroom Server class
 */
public class Server extends JFrame {

    private JTextField textField;
    private JTextArea chatWindow;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ServerSocket serverSocket;
    private Socket connectionSocket;

    // constructor
    public Server() {
        super("Geoff's Instant Messenger");
        textField = new JTextField();
        textField.setEditable(false);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                sendMessage(event.getActionCommand());
                textField.setText("");
            }
        });
        add(textField, BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300, 150); // Sets the window size
        setVisible(true);
    }

    /**
     * Start the server
     */
    public void startRunning() {
        try {

            // 6789 is a dummy port for testing
            // The 100 is the maximum people waiting to connect.
            serverSocket = new ServerSocket(6789, 100);
            while (true) {
                try {
                    // Trying to connect and have conversation
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                } catch (EOFException eofException) {
                    showMessage("\n Server ended the connection! ");
                } finally {
                    closeConnection();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * wait for connection, then display connection information
     * 
     * @throws IOException
     */
    private void waitForConnection() throws IOException {
        showMessage(" Waiting for someone to connect... \n");
        connectionSocket = serverSocket.accept();
        showMessage(" Now connected to " + connectionSocket.getInetAddress().getHostName());
    }

    /**
     * get stream to send and receive data
     * 
     * @throws IOException
     */
    private void setupStreams() throws IOException {
        outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
        outputStream.flush();

        inputStream = new ObjectInputStream(connectionSocket.getInputStream());

        showMessage("\n Streams are now setup \n");
    }

    /**
     * during the chat conversation
     * 
     * @throws IOException
     */
    private void whileChatting() throws IOException {
        String message = " You are now connected! ";
        sendMessage(message);
        ableToType(true);
        do {
            try {
                message = (String) inputStream.readObject();
                showMessage("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                showMessage("The user has sent an unknown object!");
            }
        } while (!message.equals("CLIENT - END"));
    }

    /**
     * close the connection
     */
    public void closeConnection() {
        showMessage("\n Closing Connections... \n");
        ableToType(false);
        try {
            // Closes the output path to the client
            outputStream.close();
            // Closes the input path to the server, from the client.
            inputStream.close();
            // Closes the connection between you can the client
            connectionSocket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Send a mesage to the client
     * 
     * @param message
     */
    private void sendMessage(String message) {
        try {
            outputStream.writeObject("SERVER - " + message);
            outputStream.flush();
            showMessage("\nSERVER -" + message);
        } catch (IOException ioException) {
            chatWindow.append("\n ERROR: CANNOT SEND MESSAGE, PLEASE RETRY");
        }
    }

    /**
     * update chatWindow
     * 
     * @param text
     */
    private void showMessage(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                chatWindow.append(text);
            }
        });
    }

    /**
     * sets the text field editable
     * 
     * @param tof
     */
    private void ableToType(final boolean tof) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textField.setEditable(tof);
            }
        });
    }
}