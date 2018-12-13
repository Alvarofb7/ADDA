package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLista {

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
}
