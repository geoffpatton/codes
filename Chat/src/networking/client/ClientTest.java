package networking.client;

import javax.swing.JFrame;

/**
 * @author general
 *         Chatroom test class
 *         Run to start client
 *
 */
public class ClientTest {

    public static void main(String[] args) {
        Client client;
        // specify server address
        client = new Client("127.0.0.1");
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.startRunning();
    }
}