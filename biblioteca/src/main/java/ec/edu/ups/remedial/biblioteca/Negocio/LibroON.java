package ec.edu.ups.remedial.biblioteca.Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.remedial.biblioteca.DAO.LibroDAO;
import ec.edu.ups.remedial.biblioteca.modelo.Libro;

@Stateless
public class LibroON implements LibroONLOCAL{

	@Inject
	private LibroDAO daoLibro;

	public Libro buscarLibro(int libro_id) throws Exception {
		Libro libro = new Libro();
		try {
			libro = daoLibro.readlibro(libro_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al buscar el libro");
		}
		return libro;
	}

	public List<Libro> listarLibro(int categoria_id) throws Exception{
		List<Libro> listarLibro = new ArrayList<>();
		
		try {
			listarLibro=daoLibro.listarLibro(categoria_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al listar.");
		}
		return listarLibro;
	}
}
