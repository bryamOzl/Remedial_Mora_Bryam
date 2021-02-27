package ec.edu.ups.remedial.biblioteca.clienteREST;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import ec.edu.ups.remedial.biblioteca.modelo.Libro;


public class LibroCLI {
	
	private String WS_GET_LIBRO = "http://localhost:8080/biblioteca/ws/libro/buscarL";
	private String WS_GET_LIBROS = "http://localhost:8080/biblioteca/ws/libro/listarl";

	
	public Libro getLibro(int libro_id) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(WS_GET_LIBRO).queryParam("libro_id", libro_id);

		Libro libro = target.request().get(Libro.class);

		client.close();

		return libro;
	}
	
	public List<Libro> listarLibro(int categoria_id) {
		List<Libro> listarLibro = new ArrayList<Libro>();
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(WS_GET_LIBROS).queryParam("categoria_id", categoria_id);

		listarLibro = target.request().get(new GenericType<List<Libro>>() {
		});

		client.close();
		return listarLibro;
	}

}
