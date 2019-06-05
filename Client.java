
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Client {

	// public static void main(String args[]) {
	// Client client = new Client("127.0.0.1", 5000);
	// }
	// initialize socket and input output streams
	private Socket socket;
	// private BufferedInputStream input;
	private Scanner input;
	private PrintWriter out;
	private DataOutputStream output = null;
	private DataInputStream input2 = null;

	// constructor to put ip address and port
	public Client(String address, int port) {
		// establish a connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			input2 = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());

		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}

		// string to read message from input
		String line = "";		

		// keep reading until "Over" is input
		while (!line.equals("Exit")) {
			try {
				line = input2.readUTF();
			} catch (IOException e) {
				// TODO Automatisch generierter Erfassungsblock
				e.printStackTrace();
			}

		}

		// close the connection
		try {
			input.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	private void sendMessage() {

	}
}