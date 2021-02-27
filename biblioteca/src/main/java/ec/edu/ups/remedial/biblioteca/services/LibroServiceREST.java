package ec.edu.ups.remedial.biblioteca.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.remedial.biblioteca.Negocio.LibroONLOCAL;
import ec.edu.ups.remedial.biblioteca.modelo.Libro;

@Path("libro")
public class LibroServiceREST {

	@Inject
	private LibroONLOCAL onLibro;

	@GET
	@Produces("application/json")
	@Path("buscarL")
	public Libro buscarLibro(@QueryParam("libro_id") int libro_id) throws Exception {
		Libro libro = new Libro();
		libro = onLibro.buscarLibro(libro_id);
		return libro;
	}

	@GET
	@Produces("application/json")
	@Path("listarl")
	public List<Libro> listarLibros(@QueryParam("categoria_id") int categoria_id) throws Exception {
		return onLibro.listarLibro(categoria_id);
	}

}
