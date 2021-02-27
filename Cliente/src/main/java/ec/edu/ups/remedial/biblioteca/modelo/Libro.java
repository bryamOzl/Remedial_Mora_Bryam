package ec.edu.ups.remedial.biblioteca.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigoLibro;
	private String nombreLibro;
	private int stock;
	private String estado;
	private Categoria categoria;

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Libro [codigoLibro=" + codigoLibro + ", nombreLibro=" + nombreLibro + ", stock=" + stock + ", estado="
				+ estado + ", categoria=" + categoria + "]";
	}

}
