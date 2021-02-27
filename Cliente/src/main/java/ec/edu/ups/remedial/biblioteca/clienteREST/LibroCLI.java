package ec.edu.ups.remedial.biblioteca.clienteREST;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import ec.edu.ups.remedial.biblioteca.modelo.Libro;


public class LibroCLI {
	
	private String WS_GET_VEHICULO = "http://localhost:8080/biblioteca/ws/libro/buscarL";
	
	public Libro getLibro(int libro_id) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(WS_GET_VEHICULO).queryParam("libro_id", libro_id);

		Libro libro = target.request().get(Libro.class);

		client.close();

		return libro;
	}

}
