package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

//	PI2.4 (78). Dada una lista de palabras, ordenada alfabéticamente, se desea encontrar la posición
//	de la palabra dada P y si no está devolverá -1. Se quiere diseñar un algoritmo que divida el vector
//	en tres partes y seguir buscando en el tercio correspondiente.

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("f");
		l.add("g");
		l.add("h"); 
		l.add("i");
		l.add("j");
		l.add("k");
		l.add("l");
		l.add("m");
		l.add("n");
		l.add("o");
		l.add("p");
		l.add("q");
		l.add("r");
		l.add("s");
		l.add("t");
		l.add("u");
		l.add("v");
		l.add("w");
		l.add("x");
		l.add("y");
		l.add("z");
		
		System.out.println(l);
//		System.out.println("alvaro: " + busquedaIndice(l, "alvaro"));
//		for(int i=0; i<l.size(); i++) {
//			System.out.println("El índice de " + l.get(i) + " es " + busquedaIndice(l, l.get(i)));
//		}

	}

	public static Integer busquedaIndice(List<String> l, String p) {
		return busquedaIndice(l, p, 0, l.size() / 3, (2 * l.size()) / 3, l.size() - 1);
	}
	
	private static Integer busquedaIndice(List<String> l, String p, int i, int j, int k, int z) {
		Integer res = -1;
		if (z - i <= 5 && !l.contains(p)) {
			return res;
		} else {
			if (l.get(i) == p) {
				return i;
			} else if (l.get(j) == p) {
				return j;
			} else if (l.get(k) == p) {
				return k;
			} else if (l.get(z) == p) {
				return z;
			} else if (l.get(j).compareTo(p) > 0) {
				return busquedaIndice(l, p, i, ((j - i) / 3) + i, ((2 * (j - i)) / 3) + i, j);
			} else if (l.get(j).compareTo(p) < 0 && l.get(k).compareTo(p) > 0) {
				return busquedaIndice(l, p, j + 1, ((k - (j + 1)) / 3) + (j + 1), (2 * (k - (j + 1)) / 3) + (j + 1), k);
			} else if (l.get(k).compareTo(p) < 0) {
				return busquedaIndice(l, p, k + 1, ((z - (k + 1)) / 3) + (k + 1), (2 * (z - (1 + k)) / 3) + (k + 1), z);
			}
		}
		return res;
	}
}