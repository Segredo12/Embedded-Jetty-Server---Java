package pt.segredo12.jettyServer.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/*
 * @Created: Octávio Marques.
 */
public class JettyServer extends Server {
	
	// Server const:
	private Server server;
	
	// URL Prefix:
	private final String urlPrefix = "/rest";
	
	// Port to use:
	private int port = 8080;
	
	// Init Constants:
	private final String initPackage = "pt.segredo12.jettyServer";
	private final String authFilterPath = "pt.segredo12.jettyServer.filter.AuthFilter";
	
	// Prepares Server:
	public JettyServer() {
		super();
		this.server = new Server(port);
		ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
		server.setHandler(context);
		
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter("jersey.config.server.provider.packages", initPackage); // Adds Package Providers;
		sh.setInitParameter("javax.ws.rs.container.ContainerRequestFilter", authFilterPath); // Adds our Custom AuthFilter;
		context.addServlet(sh, urlPrefix+"/*");
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
