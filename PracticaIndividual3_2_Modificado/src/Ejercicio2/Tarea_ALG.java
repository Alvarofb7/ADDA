package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Tarea_ALG {

	public static Tarea crearTarea(Integer duracion) {
		return new Tarea(duracion);
	}
	
	public static Tarea crearTareaString(String s) {
		return new Tarea(s);
	}
	
	public static List<Tarea> crearTareaFichero(String nombreArchivo){
		List<Tarea> res = new ArrayList<>();
		for(String linea : LeerFichero.leeFichero(nombreArchivo)) {
		res.add(new Tarea(linea));
	}
	return res;
	}
}
