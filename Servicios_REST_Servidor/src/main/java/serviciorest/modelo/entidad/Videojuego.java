package serviciorest.modelo.entidad;

import java.util.Objects;

public class Videojuego {
	private int id;
	private String nombre;
	private String compañia;
	private double nota;
	
	public Videojuego() {
		super();
	}
	
	public Videojuego(int id, String nombre, String compañia, Double nota ) {
		this.id = id;
		this.nombre = nombre;
		this.compañia = compañia;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCompañia() {
		return compañia;
	}
	public void  setCompañia(String compañia) {
		this.compañia = compañia;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Videojuegos [id=" + id + ", nombre=" + nombre + ", compañia=" + compañia + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}
	
}