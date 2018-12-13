package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {

//	PI1.3 (63). Obtener una List<Integer> a partir de un fichero de texto que contiene en cada línea
//	una lista de números enteros separados por comas. 

//	PARA CADA PROBLEMA SE PIDE:
//		a) Implementar una solución iterativa (C y JAVA).
//		b) Implementar una solución con stream en JAVA 10.
//		c) Implementar una solución recursiva lineal final (C y JAVA).
//		d) Definir los tamaños y calcular los T(n) para las distintas funciones implementadas considerando los
//		casos mejor y peor. 

	public static void main(String[] args) {

		List<String> lineas = Files2.getLines("Practica.txt");
		System.out.println("Resultado con While: " + listaEnterosWhile(lineas));
		System.out.println("Resultado con Recursivo: " + listaEnterosRecursivosConMem(lineas, 0, 0, 12, 0));
		System.out.println("Resultado con Stream: " + listaEnteroStream(lineas));

	}

	// Iterativa
	public static List<Integer> listaEnterosWhile(List<String> lineas) {
		List<Integer> res = new ArrayList<Integer>();
		Integer filas = 0;
		Integer indice = 0;
		while (filas <= lineas.size() - 1) {
			String[] partes = lineas.get(filas).split(",");
			if (indice < partes.length) {
				String num = partes[indice];
				Integer num2 = Integer.parseInt(num);
				res.add(num2);
				indice++;
			} else if (indice == partes.length) {
				filas++;
				indice = 0;
			}
		}
		return res;
	}

	// Recursivo
	public static List<Integer> listaEnterosRecursivosConMem(List<String> lineas, Integer indice, Integer filas,
			Integer n, Integer contador) {
		return listaEnterosRecursivoConMem(lineas, indice, filas, new ArrayList<Integer>(), n, contador);
	}

	private static List<Integer> listaEnterosRecursivoConMem(List<String> lineas, Integer indice, Integer filas,
			ArrayList<Integer> res, Integer n, Integer contador) {
		String[] partes = lineas.get(filas).split(",");
		if (contador == n) {
			return res;
		} else {
			if (filas == lineas.size() - 1 && indice == partes.length - 1) {
				String num = partes[indice];
				Integer num2 = Integer.parseInt(num);
				res.add(num2);
				return res;
			} else {
				if (indice < partes.length) {
					String num = partes[indice];
					Integer num2 = Integer.parseInt(num);
					res.add(num2);
					listaEnterosRecursivoConMem(lineas, indice + 1, filas, res, n , contador+1);
				} else if (indice == partes.length) {
					listaEnterosRecursivoConMem(lineas, 0, filas + 1, res, n, contador);
					
				}
			}
		}
		return res;
	}

	// Java10
	public static List<Integer> listaEnteroStream(List<String> lineas) {
		List<Integer> res = lineas.stream().flatMap(s -> Stream.of(s.split(","))).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return res;
	}

}
