package Ejercicios;

public class Ejercicio76 {

	public static void main(String[] args) {
		Integer[] v = { 6, 7, 8 ,9 , 1, 2, 3, 4, 5 };
		System.out.println(mayor(v));
	}

	public static Integer mayor(Integer[] v) {
		return mayor(v, 0, v.length-1);
	}

	private static Integer mayor(Integer[] v, int i, int j) {
		Integer res = -1;
		if (j - i <= 1) {
			res = i;
		} else {
			Integer k = (i + j) / 2;
			if (v[k] > v[k - 1] && v[k] > v[k + 1]) {
				res = v[k];
			} else if (v[k] < v[k - 1]) {
				res = mayor(v, i, k - 1);
			} else if (v[k] < v[k + 1]) {
				res = mayor(v, k + 1, j);
			}
		}
		return res;
	}

}
