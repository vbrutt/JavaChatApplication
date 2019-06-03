package de.application;

public class Main {

	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.launchServer(1337);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
