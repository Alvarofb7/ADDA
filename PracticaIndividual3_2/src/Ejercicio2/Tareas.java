package Ejercicio2;

public class Tareas {
	private Integer id, duracion;

	public static Tareas create(String s) {
		return new Tareas(s);
	}
	
	private Tareas(String s) {
		String[] t = s.split(",");
		id = Integer.parseInt(t[0]);
		duracion = Integer.parseInt(t[1]);
	}

	public Integer getId() {
		return id;
	}

	public Integer getDuracion() {
		return duracion;
	}
	
}
