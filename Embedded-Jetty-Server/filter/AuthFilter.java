package pt.segredo12.jettyServer.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import com.sun.messaging.jmq.io.Status;

/*
 * @Created: Octávio Marques.
 */
@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext req) throws IOException {
		String method = req.getMethod();
		String path = req.getUriInfo().getPath(true);
		
		/*
		 * Could check the path
		 * * Validation which paths should use authorization or not;
		 */
		
		// Tries to get Authorization Header;
		String auth = req.getHeaderString("authorization");
		
		// In case authorization header isn't used it throws an Status.UNAUTHORIZED;
		if (auth == null) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
		
		/*
		 * In case authentication is used and brings data:
		 * * Data will come with a similar format: Basic (base64.String)
		 * * * That's why we need to decode it so we can receive raw values;
		 */
		String base64Creds = auth.substring("Basic".length()).trim(); // Here we're removing Basic from it;
		byte[] credDecod = Base64.getDecoder().decode(base64Creds); // Decodes Base64 Encoded String into an Byte Array decoded;
		String cred = new String(credDecod, StandardCharsets.UTF_8); // Transforms Byte Array into a valid String with the next format: (username:password);
		final String[] credFields = cred.split(":", 2); // Finally we have username on position [0] and password on [1]; 
		
		/*
		 * Checks with a database or other way of passwords storage;
		 * * Using any type of encryption;
		 */
		
		/*
		 * From here you do you;
		 */
		
	}
}
