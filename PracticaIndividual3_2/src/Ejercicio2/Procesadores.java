package Ejercicio2;

public class Procesadores {
	private Integer id;

	public static Procesadores create(String s) {
		return new Procesadores(s);
	}
	
	private Procesadores(String s) {
		id = Integer.parseInt(s);
	}
	
	public Integer getId() {
		return id;
	}
}
