
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;


public class Client {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private Scanner scanner;
	private static final Logger LOG = Logger.getLogger(Client.class.getName());
	private String userInput = "";

	public Client(String address, int port) {
		while (!(userInput.equals("exit"))) {
			try {
				socket = new Socket(address, port);

				output = socket.getOutputStream();
				OutputStreamWriter streamWriter = new OutputStreamWriter(output);
				BufferedWriter writer = new BufferedWriter(streamWriter);

				scanner = new Scanner(System.in);
				userInput = scanner.nextLine() + "\n";

				writer.write(userInput);
				writer.flush();
				LOG.info("Message sent to the server : " + userInput);

				// Um möglicherweise eine Antwort vom Server bzw. über den Server von dem
				// anderen Client zu bekommen
				/**
				 * input = socket.getInputStream(); InputStreamReader streamReader = new
				 * InputStreamReader(input); BufferedReader reader = new
				 * BufferedReader(streamReader); String returnedMessage = reader.readLine();
				 * LOG.info("Message from the server: " + returnedMessage);
				 */

			} catch (IOException e) {
				LOG.info(e.getStackTrace().toString());
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					LOG.info(e.getStackTrace().toString());
				}

			}

		}

	}

	public static void main(String[] args) {
		new Client("localhost", 1337);
	}
}
