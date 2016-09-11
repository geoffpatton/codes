package networking.chatClient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author general 
 * 
 * Chatroom client class
 */
public class Client extends JFrame {

	private JTextField textField;
	private JTextArea chatWindow;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private String message = "";
	private String serverIP;
	private Socket socket;

	// constructor
	public Client(String host) {
		super("Client");
		serverIP = host;
		// create the textField
		textField = new JTextField();
		textField.setEditable(false);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				sendMessage(event.getActionCommand());
				textField.setText("");
			}
		});
		// add text field to bottom of window
		add(textField, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		// set the window size
		setSize(300, 150);
		setVisible(true);
	}

	/**
	 * connects to the server
	 */
	public void startRunning() {
		try {
			connectToServer();
			// set up input and output streams
			setupStreams();
			whileChatting();
		} catch (EOFException eofException) {
			showMessage("\n Client terminated the connection");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * connect to the server
	 * @throws IOException
	 */
	private void connectToServer() throws IOException {
		showMessage("Connecting to Server... \n");
		socket = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("Connection Established! Connected to: " + socket.getInetAddress().getHostName());
	}

	/**
	 * set up streams
	 * @throws IOException
	 */
	private void setupStreams() throws IOException {
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(socket.getInputStream());
		showMessage("\n The streams are now set up! \n");
	}

	/**
	 * while chatting with server
	 * @throws IOException
	 */
	private void whileChatting() throws IOException {
		ableToType(true);
		do {
			try {
				message = (String) inputStream.readObject();
				showMessage("\n" + message);
			} catch (ClassNotFoundException classNotFoundException) {
				showMessage("Unknown data received!");
			}
		} while (!message.equals("SERVER - END"));
	}

	/**
	 * Close connection
	 */
	private void closeConnection() {
		showMessage("\n Closing the connection!");
		ableToType(false);
		try {
			outputStream.close();
			inputStream.close();
			socket.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * send message to server
	 * @param message
	 */
	private void sendMessage(String message) {
		try {
			outputStream.writeObject("CLIENT - " + message);
			outputStream.flush();
			showMessage("\nCLIENT - " + message);
		} catch (IOException ioException) {
			chatWindow.append("\n Oops! Something went wrong!");
		}
	}

	/**
	 * update chat window
	 * @param message
	 */
	private void showMessage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				chatWindow.append(message);
			}
		});
	}

	/**
	 * allows user to type
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