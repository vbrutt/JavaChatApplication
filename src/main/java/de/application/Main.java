package de.application;

public class Main {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Cannot start application. Use either 'server' or 'client' as argument!");
			System.exit(1);
		} else if (args[0].equals("server")) {
			try {
				Server server = new Server();
				server.launchServer(1337);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (args[0].equals("client")) {
			// TODO
		}
	}
}
