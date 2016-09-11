package networking.chatServer;

import javax.swing.JFrame;

/**
 * @author general 
 * Server test class 
 * Run to start the server
 */
public class ServerTest {

	public static void main(String[] args) {
		Server sally = new Server();
		sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sally.startRunning();
	}
}
