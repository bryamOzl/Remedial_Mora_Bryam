package ec.edu.ups.remedial.biblioteca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import ec.edu.ups.remedial.biblioteca.modelo.Autor;
import ec.edu.ups.remedial.biblioteca.modelo.Categoria;
import ec.edu.ups.remedial.biblioteca.modelo.LibAut;
import ec.edu.ups.remedial.biblioteca.modelo.Libro;

@Stateless
public class LibroDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;

	public boolean insertLibro(Libro libro) throws SQLException {
		em.persist(libro);
		return true;
	}

	public boolean insertInter(LibAut libAut) throws SQLException {
		em.persist(libAut);
		return true;
	}

	public List<Categoria> listarCategoria() {
		List<Categoria> listarCategoria = new ArrayList<>();
		String sql = "SELECT * FROM Categoria";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Categoria categoria = new Categoria();
				categoria.setCodigoCategoria(res.getInt("categoria_id"));
				categoria.setCategoria(res.getString("categoria"));
				listarCategoria.add(categoria);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar la categoria " + e.getMessage());
		}
		return listarCategoria;
	}

	public List<Autor> listarAutor() {
		List<Autor> listarAutor = new ArrayList<>();
		String sql = "SELECT * FROM Autor";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Autor autor = new Autor();
				autor.setCodigoAutor(res.getInt("autor_id"));
				autor.setNombre(res.getString("nombre"));
				listarAutor.add(autor);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar la categoria " + e.getMessage());
		}
		return listarAutor;
	}

	public int contarLibro() throws SQLException {
		int s;
		String sql = "SELECT MAX (libro_id) FROM libro";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}

	public int contarInter() throws SQLException {
		int s;
		String sql = "SELECT MAX (libaut_id) FROM libaut";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}

	public Autor readAutor(int autor_id) throws SQLException {
		Autor autor = em.find(Autor.class, autor_id);
		return autor;
	}

	public Categoria readCategoria(int categoria_id) throws SQLException {
		Categoria categoria = em.find(Categoria.class, categoria_id);
		return categoria;
	}

	public Libro readlibro(int libro_id) throws SQLException {
		Libro libro = em.find(Libro.class, libro_id);
		return libro;
	}

	public List<Libro> listarLibro(int categoria_id) {

		List<Libro> listarLibro = new ArrayList<>();
		String sql = "SELECT * FROM libro l WHERE l.categoria_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoria_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Libro libro = new Libro();
				libro.setCodigoLibro(res.getInt("libro_id"));
				libro.setNombreLibro(res.getString("nombrelibro"));
				libro.setEstado(res.getString("estado"));
				libro.setStock(res.getInt("stock"));
				libro.setCategoria(readCategoria(res.getInt("categoria_id")));
				listarLibro.add(libro);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar los Libros " + e.getMessage());
		}
		return listarLibro;
	}
}
