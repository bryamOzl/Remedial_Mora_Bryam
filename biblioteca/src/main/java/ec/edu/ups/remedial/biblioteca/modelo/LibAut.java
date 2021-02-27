package ec.edu.ups.remedial.biblioteca.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LibAut implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "libaut_id")
	private int codigoLibaut;
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro libro;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	public int getCodigoLibaut() {
		return codigoLibaut;
	}

	public void setCodigoLibaut(int codigoLibaut) {
		this.codigoLibaut = codigoLibaut;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "LibAut [codigoLibaut=" + codigoLibaut + ", fecha=" + fecha + ", libro=" + libro + ", autor=" + autor
				+ "]";
	}

}
