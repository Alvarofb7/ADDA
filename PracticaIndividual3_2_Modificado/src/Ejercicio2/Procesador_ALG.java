package Ejercicio2;

import java.util.HashSet;
import java.util.Set;

public class Procesador_ALG {

	public static Procesador creaProcesador(String nombre) {
		return new Procesador(nombre);
	}
	
	public static Procesador crearProcesadorString(String s) {
		return new Procesador(s);
	}
	
	public static Set<Procesador> crearProcesador(String nombreArchivo){
		Set<Procesador> res = new HashSet<>();
		for(String linea : LeerFichero.leeFichero(nombreArchivo)) {
			res.add(new Procesador(linea));
		}
		return res;
	}
	
}
