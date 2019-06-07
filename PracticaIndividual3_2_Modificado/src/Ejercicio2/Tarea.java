package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Tarea {

	private Integer duracion;
	private Integer id=0;


	public static Tarea create(Integer duracion) {
		return new Tarea(duracion);
	}
	
	public Tarea(Integer duracion) {
		super();
		this.duracion = duracion;
		id++;
	}
	
	public Tarea(String s) {
		String[] partes = s.split(";");
		Integer duracion = Integer.parseInt(partes[0]);
		this.duracion = duracion;
	}

	public static Tarea create(String s) {
		String[] partes = s.split(";");
		Integer duracion = Integer.parseInt(partes[0]);
		return new Tarea(duracion);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	public void setDuracion(Integer duracion) { 
		this.duracion = duracion;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarea [duracion=" + duracion + "]";
	}
	
	
}
