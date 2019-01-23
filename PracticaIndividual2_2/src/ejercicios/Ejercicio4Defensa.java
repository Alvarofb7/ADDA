package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4Defensa {

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
		System.out.println("alvaro: " + busquedaIndice(l, "alvaro"));
		for(int i=0; i<l.size(); i++) {
			System.out.println("El índice de " + l.get(i) + " es " + busquedaIndice(l, l.get(i)));
		}
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(0);
		l2.add(1);
		l2.add(3);
		l2.add(5);
		l2.add(8);
		l2.add(9);
		l2.add(13);
		l2.add(14);
		l2.add(16);
		l2.add(18);
		l2.add(24);
		l2.add(27);
		l2.add(30);
		l2.add(34);
		System.out.println("-----------------------------------------------------");
		System.out.println("Indice: " + busquedaIndice(l2, 9));
		
		
	}

	public static <T extends Comparable<T>> Integer busquedaIndice(List<T> l, T p) {
		return busquedaIndice(l, p, 0, l.size() / 3, (2 * l.size()) / 3, l.size() - 1);
	}
	
	private static <T extends Comparable<T>> Integer busquedaIndice(List<T> l, T p, int i, int j, int k, int z) {
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
