package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4_Generico {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		l1.add(0);
		l1.add(2);
		l1.add(4);
		l1.add(6);
		l2.add(1);
		l2.add(3);
		l2.add(5);
		l2.add(7);
		l2.add(8);
		l2.add(9);
		List<String> ls1 = new ArrayList<String>();
		List<String> ls2 = new ArrayList<String>();
		ls1.add("adda");
		ls2.add("sistemas");
		ls1.add("logica");
		ls2.add("redes");
		ls1.add("iissi");
		System.out.println("Solución Iterativa Integer: " + fusionListasWhile(l1, l2));
		System.out.println("Solución Iterativa String: " + fusionListasWhile(ls1, ls2));
		System.out.println("Solución Recursiva Integer: " + fusionListasRecursivoConMem(l1, l2));
		System.out.println("Solución Recursiva String: " + fusionListasRecursivoConMem(ls1, ls2));
		System.out.println("Solución Stream Integer: " + fusionListasJava10(l1, l2));
		System.out.println("Solución Stream String: " + fusionListasJava10(ls1, ls2));
	}

	// Iterativa
	public static <T extends Comparable<T>> List<T> fusionListasWhile(List<T> l1, List<T> l2) {
		List<T> res = new ArrayList<T>();
		Integer indice1 = 0;
		Integer indice2 = 0;
		while (indice1 != l1.size() || indice2 != l2.size()) {
			if (indice1 == l1.size()) {
				res.add(l2.get(indice2));
				indice2++;
			} else if (indice2 == l2.size()) {
				res.add(l1.get(indice1));
				indice1++;
			} else if (l1.get(indice1).compareTo(l2.get(indice2)) > 0) {
				res.add(l2.get(indice2));
				indice2++;
			} else if (l1.get(indice1).compareTo(l2.get(indice2)) == 0) {
				res.add(l2.get(indice2));
				indice1++;
				indice2++;
			} else if (l1.get(indice1).compareTo(l2.get(indice2)) < 0) {
				res.add(l1.get(indice1));
				indice1++;
			}
		}
		return res;
	}

	// Java10
	public static <T extends Comparable<T>> List<T> fusionListasJava10(List<T> l1, List<T> l2) {
		List<T> res = Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
		MergeSortLista.Sort(res);
		return res;
	}

	// Recursividad
	public static <T extends Comparable<T>> List<T> fusionListasRecursivoConMem(List<T> l1, List<T> l2) {
		Integer indice1 = 0;
		Integer indice2 = 0;
		List<T> res = new ArrayList<T>();
		return fusionListasRecursivoConMem(l1, l2, indice1, indice2, res);
	}

	private static <T extends Comparable<T>> List<T> fusionListasRecursivoConMem(List<T> l1, List<T> l2,
			Integer indice1, Integer indice2, List<T> res) {

		if (indice1 == l1.size() && indice2 == l2.size()) {
			return res;

		} else {
			if (indice1 == l1.size() && indice2 != l2.size()) {
				res.add(l2.get(indice2));
				fusionListasRecursivoConMem(l1, l2, indice1, indice2 + 1, res);

			} else if (indice2 == l2.size() && indice1 != l1.size()) {
				res.add(l1.get(indice1));
				fusionListasRecursivoConMem(l1, l2, indice1 + 1, indice2, res);

			} else if (l1.get(indice1).compareTo(l2.get(indice2)) < 0) {
				res.add(l1.get(indice1));
				fusionListasRecursivoConMem(l1, l2, indice1 + 1, indice2, res);

			} else if (l1.get(indice1).compareTo(l2.get(indice2)) == 0) {
				res.add(l2.get(indice2));
				fusionListasRecursivoConMem(l1, l2, indice1 + 1, indice2 + 1, res);

			} else if (l1.get(indice1).compareTo(l2.get(indice2)) > 0) {
				res.add(l2.get(indice2));
				fusionListasRecursivoConMem(l1, l2, indice1, indice2 + 1, res);

			} else if (indice1 == l1.size() && indice2 != l2.size()) {
				res.add(l2.get(indice2));
				fusionListasRecursivoConMem(l1, l2, indice1, indice2 + 1, res);

			} else if (indice2 == l2.size() && indice1 != l1.size()) {
				res.add(l1.get(indice1));
				fusionListasRecursivoConMem(l1, l2, indice1 + 1, indice2, res);
			}
		}
		return res;
	}
}
