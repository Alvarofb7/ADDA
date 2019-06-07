package Ejercicio2;

public class Procesador {

	private String nombre;
	
	public Procesador(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	public static Procesador create(String nombre) {
		return new Procesador(nombre);
	}
	
	public String getNombre() { 
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Procesador other = (Procesador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procesador [nombre=" + nombre + "]";
	}
	
	
	
}
