package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class SucesionEspecialmenteCreciente {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		System.out.println(esECrecienteRec(l1));
		System.out.println(esECrecienteRecF(l1));
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(6);
		l2.add(18);
		l2.add(20);
		l2.add(22);
		System.out.println("\n" + esECrecienteRec(l2));
		System.out.println(esECrecienteRecF(l2));
	}

	public static Boolean esECrecienteRec(List<Integer> l) {
		return esECrecienteRec(l, 0);
	}

	private static Boolean esECrecienteRec(List<Integer> l, int i) {
		Boolean res;
		if (i == l.size() - 1) {
			res = true;
		} else {
			res = (l.get(i) < l.get(i + 1)) && (l.get(i+1) % 2 == 0 || l.get(i + 1) % l.get(i) == 0)
					&& esECrecienteRec(l, i + 1);
		}
		return res;
	}
	
	public static Boolean esECrecienteRecF(List<Integer> l) {
		return esECrecienteRecF(l, 0, true);
	}

	private static Boolean esECrecienteRecF(List<Integer> l, int i, Boolean ac) {
		Boolean res;
		if (i == l.size() - 1) {
			res = ac;
		} else {
			res = esECrecienteRecF(l, i + 1, ac && (l.get(i) < l.get(i + 1)) && 
					(l.get(i+1) % 2 == 0 || l.get(i + 1) % l.get(i) == 0));
		}
		return res;
	}
	

}
