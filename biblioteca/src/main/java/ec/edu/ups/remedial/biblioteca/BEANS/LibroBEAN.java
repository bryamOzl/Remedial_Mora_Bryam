package ec.edu.ups.remedial.biblioteca.BEANS;

import java.sql.SQLException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.remedial.biblioteca.DAO.LibroDAO;
import ec.edu.ups.remedial.biblioteca.modelo.Autor;
import ec.edu.ups.remedial.biblioteca.modelo.Categoria;
import ec.edu.ups.remedial.biblioteca.modelo.LibAut;
import ec.edu.ups.remedial.biblioteca.modelo.Libro;

@ManagedBean
@ViewScoped
public class LibroBEAN {

	private Libro libro = new Libro();
	private LibAut libaut = new LibAut();
	private Autor autor = new Autor();
	private Categoria categoria = new Categoria();


	@Inject
	private LibroDAO daoLibro;

	public void registroLibro() throws SQLException {

		try {
			categoria.setCodigoCategoria(1);
			libro.setCodigoLibro(daoLibro.contarLibro());
			libro.setEstado("DISPONIBLE");
			libro.setCategoria(categoria);
			daoLibro.insertLibro(libro);
			registroLibAut();
			libro = null;
			System.out.println("LIBRO GUARDADO");
		} catch (Exception e) {
			System.out.println("ERROR" + e);
		}
	}

	public void registroLibAut() throws SQLException {
		java.util.Date fecha = new Date();
		autor.setCodigoAutor(1);
		libaut.setCodigoLibaut(daoLibro.contarInter());
		libaut.setFecha(fecha);
		libaut.setLibro(libro);
		libaut.setAutor(autor);
		daoLibro.insertInter(libaut);
		libaut = null;
		System.out.println("LIBRO AUTOR GUARDADO");
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public LibAut getLibaut() {
		return libaut;
	}

	public void setLibaut(LibAut libaut) {
		this.libaut = libaut;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
