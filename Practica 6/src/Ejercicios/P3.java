package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P3 {
//P3 - (EJ43) Encontrar la raíz cuadrada de un número (la raíz cuadrada de un entero a es
//	el mayor valor de un entero n tal que a>=n^2). (Java) (Iterativo, Recursivo y Funcional)
//	a) Usar una búsqueda secuencial en el rango de 2..n-1
//	b) Usar una búsqueda binaria en el rango de 2..n-1
	public static void main(String[] args) {
		System.out.println("Iterativo: " + busquedaIter(101));
		System.out.println("Recursivo: " + busquedaRec(101));
		System.out.println("Funcional: " + busquedaFunc(101));

		for (int i = 1; i < 17; i++) {
			System.out.println("Raíz de " + i + " = " + "Iterativo: " + busquedaIter(i) + ", Recursivo: "
					+ busquedaRec(i) + ", Funcional: " + busquedaFunc(i));
		}
		
		System.out.println("Binario: " + binario(101));
	}

//a	
	public static Integer busquedaIter(Integer a) {
		Integer res = 0;
		Integer n = 0;
		while (n * n <= a) {
			res = n;
			n += 1;
		}
		return res;
	}

	public static Integer busquedaRec(Integer a) {
		return busquedaRec(a, 0, 0);
	}

	private static Integer busquedaRec(Integer a, int r, int n) {
		Integer res = 0;
		if (n * n > a) {
			res = r;
		} else {
			res = busquedaRec(a, n, n + 1);
		}
		return res;
	}

	public static Integer busquedaFunc(Integer a) {
		List<Integer> l = IntStream.rangeClosed(0, a).filter(n -> (n * n) <= a).boxed().collect(Collectors.toList());
		return l.get(l.size() - 1);
	}

//b
	public static Integer binario(Integer a) {
		Integer i = 1;
		Integer j = a;
		Integer r = 1;
		while (!(j - i <= 0)) {
			int n = (i+j) / 2;
			if (n * n <= a) {
				r = n;
				i = n + 1;
			} else {
				j = n;
			}
		}
		return r;
	}

}