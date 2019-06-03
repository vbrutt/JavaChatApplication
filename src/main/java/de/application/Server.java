package de.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * Launches a server instance.
	 *
	 * @param port Port number to use.
	 */
	public void launchServer(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			run(serverSocket);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Executes the server logic.
	 *
	 * @param serverSocket Server instance to use.
	 * @throws IOException In case something goes terribly wrong.
	 */
	public void run(ServerSocket serverSocket) throws IOException {
		while (true) {
			Socket client = serverSocket.accept();
			String clientAddress = client.getInetAddress().getHostAddress();
			System.out.println(clientAddress + " connected");

			try {
				BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter output = new PrintWriter(client.getOutputStream());

				while ((input.readLine()) != null) {
					output.println();
					output.flush();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
