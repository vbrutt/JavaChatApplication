
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
	private String userName;

	public Client(String userName, int port) {
		this.setUserName(userName);
		try {
			localHost = InetAddress.getLocalHost();
			address = localHost.getHostName();

			socket = new Socket(address, port);
		} catch (IOException e1) {
			LOG.info(e1.getMessage());
		}

	}

	protected void sendMessage(String userInput) {
		try {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// public static void main(String[] args) {
	// new Client("localhost", 1337);
	// }
}
