
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Client {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private static final Logger LOG = Logger.getLogger(Client.class.getName());
	private InetAddress localHost;
	private String address;
	private int port;

	public Client(String userName, int port) {
		this.port = port;
		try {
			localHost = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			LOG.info(e1.getMessage());
		}

	}

	protected void sendMessage(String userInput) {
		try {
			address = localHost.getHostAddress();
			socket = new Socket(address, port);

			output = socket.getOutputStream();
			OutputStreamWriter streamWriter = new OutputStreamWriter(output);
			BufferedWriter writer = new BufferedWriter(streamWriter);

			writer.write(userInput);
			writer.flush();
			LOG.info("Message sent to the server : " + userInput);

			// Um möglicherweise eine Antwort vom Server bzw. über den
			// Server von dem
			// anderen Client zu bekommen
			/**
			 * input = socket.getInputStream(); InputStreamReader streamReader =
			 * new InputStreamReader(input); BufferedReader reader = new
			 * BufferedReader(streamReader); String returnedMessage =
			 * reader.readLine(); LOG.info("Message from the server: " +
			 * returnedMessage);
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

	// public static void main(String[] args) {
	// new Client("localhost", 1337);
	// }
}
