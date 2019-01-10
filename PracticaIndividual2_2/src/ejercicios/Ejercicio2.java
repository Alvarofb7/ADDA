package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
//	El problema consiste en dada una lista ordenarla con respecto a un orden dado. Para
//	ello se parte la lista en dos mitades iguales, se ordena cada sublista y mezclan ordenadamente los
//	resultados mediante al algoritmo de fusión de listas (algoritmo de Mergesort).

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(8);
		l.add(2);
		l.add(5);
		l.add(1);
		l.add(6);
		l.add(3);
		l.add(7);
		l.add(4);
		System.out.println(l);
		System.out.println(Sort(l));

	}

	public static <T extends Comparable<T>> List<T> Sort(List<T> l) {
		if (l.size() >= 2) {
			List<T> listIzq = new ArrayList<T>(l.subList(0, l.size() / 2));
			List<T> listDer = new ArrayList<T>(l.subList(l.size() / 2, l.size()));
			Sort(listIzq);
			Sort(listDer);
			Merge(listIzq, listDer, l);
			return l;
		} else {
			return l;
		}
	}
	private static <T extends Comparable<T>> void Merge(List<T> listIzq, List<T> listDer, List<T> l) {
	Integer iIzq, iDer, i;
	iIzq = iDer = i = 0;
	while (iIzq < listIzq.size() && iDer < listDer.size()) {
		if (listIzq.get(iIzq).compareTo(listDer.get(iDer)) < 0) {
			l.set(i++, listIzq.get(iIzq++));
		} else if (listIzq.get(iIzq).compareTo(listDer.get(iDer)) > 0) {
			l.set(i++, listDer.get(iDer++));
		}
	}
	while (iIzq < listIzq.size()) {
		l.set(i++, listIzq.get(iIzq++));
	}
	while (iDer < listDer.size()) {
		l.set(i++, listDer.get(iDer++));
	}
}
//	public static <T extends Comparable<T>> List<T> Sort(List<T> l) {
//		if (l.size() >= 2) {
//			List<T> listIzq = new ArrayList<T>(l.subList(0, l.size() / 2));
//			List<T> listDer = new ArrayList<T>(l.subList(l.size() / 2, l.size()));
//			Sort(listIzq);
//			Sort(listDer);
//			MergeSort(l, listIzq, listDer, 0, 0, 0);
//			return l;
//		} else {
//			return l;
//		}
//	}

//	private static <T extends Comparable<T>> List<T> MergeSort(List<T> l, List<T> listIzq, List<T> listDer, int iIzq,
//			int iDer, int iL) {
//
//		if (iIzq == listIzq.size() - 1 && iDer == listDer.size() - 1) {
//			return l;
//		} else {
//			if (iDer == listDer.size() - 1) {
//				l.set(iL, listIzq.get(iIzq));
//				return MergeSort(l, listIzq, listDer, iIzq + 1, iDer, iL + 1);
//			} else if (iIzq == listIzq.size() - 1) {
//				l.set(iL, listDer.get(iDer));
//				return MergeSort(l, listIzq, listDer, iIzq, iDer + 1, iL + 1);
//			} else if (listIzq.get(iIzq).compareTo(listDer.get(iDer)) > 0) {
//				l.set(iL, listDer.get(iDer));
//				return MergeSort(l, listIzq, listDer, iIzq, iDer + 1, iL + 1);
//			} else if (listIzq.get(iIzq).compareTo(listDer.get(iDer)) == 0) {
//				l.set(iL, listDer.get(iDer));
//				return MergeSort(l, listIzq, listDer, iIzq + 1, iDer + 1, iL + 1);
//			} else if (listIzq.get(iIzq).compareTo(listDer.get(iDer)) < 0) {
//				l.set(iL, listIzq.get(iIzq));
//				return MergeSort(l, listIzq, listDer, iIzq + 1, iDer, iL + 1);
//			}
//		}
//		return l;
//	}

}
