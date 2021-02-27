package ec.edu.ups.remedial.biblioteca.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LibAuto implements Serializable{

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

	
}
