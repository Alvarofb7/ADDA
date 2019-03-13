package Ejercicios;

import us.lsi.tiposrecursivos.Tree;

public class ContarEtiquetaArbol {

	public static void main(String[] args) {
		Tree<Integer> t0 = Tree.leaf(1);
		Tree<Integer> t1 = Tree.leaf(1);
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(4);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.leaf(4);
		Tree<Integer> t = Tree.nary(0, t0, t1, t2, t3, t4, t5);
		System.out.println(cuentaXRep2(t, 3));

	}

	public static <E> Integer cuentaXRep(Tree<E> t, E x) {
		Integer ret = 0;
		if (t.isLeaf()) {
			if (!t.isEmpty() && t.getLabel().equals(x)) {
				ret = ret + 1;
			}
		} else {
			if (!t.isEmpty() && t.getLabel().equals(x)) {
				ret = ret + 1;
			}
			for (int i = 0; i < t.getNumOfChildren(); i++) {
				ret = ret + cuentaXRep(t.getChild(i), x);
			}
		}
		return ret;
	}

	public static <E> Integer cuentaXRep2(Tree<E> t, E x) {
		Integer res = 0;
		Integer c = 0;
		switch (t.getType()) {
		case Empty:
			break;
		case Leaf:
			if (t.getLabel().equals(x)) {
				res = res + 1;
			}
			break;
		case Nary:
			if (t.getLabel().equals(x)) {
				res = res + 1;
			}
//			 for(int i = 0; i < t.getNumOfChildren(); i++) {
//			 res = res + cuentaXRep2(t.getChild(i), x);
			while (c < t.getNumOfChildren()) {
				if (t.getChild(c).equals(x)) {
					res++;
					c++;
				} else {
					c++;
				}
			}
		}
		return res;
	}

}
