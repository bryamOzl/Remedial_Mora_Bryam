package ec.edu.ups.remedial.biblioteca.Negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.remedial.biblioteca.modelo.Libro;

@Local
public interface LibroONLOCAL {

	public Libro buscarLibro(int libro_id) throws Exception;
	public List<Libro> listarLibro(int categoria_id) throws Exception;
}
