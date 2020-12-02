package pt.segredo12.jettyServer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/*
 * @Created: Octávio Marques.
 */
public class JettyServer extends Server {
	
	// Server const:
	private Server server;
	
	// Port to use:
	private int port = 8080;
	
	// Prepares Server:
	public JettyServer() {
		super();
		this.server = new Server(port);
		ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
		server.setHandler(context);
	}
	
	// Used to start server:
	public void startServer() {
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Stops and destroys current server:
	public void stopServer() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}
}
