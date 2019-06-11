import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private static final Logger LOG = Logger.getLogger(Server.class.getName());
	private String clientAddress;

	/**
	 * Launches a server instance.
	 *
	 * @param port
	 *            Port number to use.
	 */
	public Server(int port) {
		try {
			this.serverSocket = new ServerSocket(port);
			LOG.info("Starting server on port " + port + "...");

			socket = serverSocket.accept();
			clientAddress = socket.getInetAddress().getHostName();
			LOG.info(clientAddress + " connected");
		} catch (IOException e) {
			LOG.info(e.getStackTrace().toString());
		}
	}

	/**
	 * Executes the server logic.
	 * @param  
	 *
	 * @param serverSocket
	 *            Server instance to use.
	 * @throws IOException
	 *             In case something goes terribly wrong.
	 */
	public void launchServer() {
		LOG.info("Server has been started. Waiting for clients to connect...");

		while (true) {
			try {
				input = socket.getInputStream();
				InputStreamReader iStreamReader = new InputStreamReader(input);

				BufferedReader reader = new BufferedReader(iStreamReader);
				String message = reader.readLine();
				LOG.info("Message received from client " + clientAddress + "is:  " + message);

				// Wenn andere users connected sind, können wir damit
				// Nachrichten an den client
				// senden

				/**
				 * String returnMessage = "blabla" + "\n"; output =
				 * socket.getOutputStream(); OutputStreamWriter oStremWriter =
				 * new OutputStreamWriter(output); BufferedWriter writer = new
				 * BufferedWriter(oStremWriter); writer.write(returnMessage);
				 * writer.flush();
				 */

			} catch (IOException e) {
				LOG.info(e.getStackTrace().toString());
			}

		}
	}

	public static void main(String[] args) {
		Server server = new Server(9090);
		server.launchServer();
	}
}
