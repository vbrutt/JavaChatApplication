import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Cannot start application. Use either 'server' or 'client' as argument!");
			System.exit(1);
		} else if (args[0].equalsIgnoreCase("server")) {
			try {
				Server server = new Server();
				server.launchServer(1337);
			} catch (Exception e) {
				LOG.log(Level.SEVERE, e.getMessage());				
			}
		} else if (args[0].equalsIgnoreCase("client")) {
			Client client = new Client("10.151.128.253", 1337);
			
		}
	}
}