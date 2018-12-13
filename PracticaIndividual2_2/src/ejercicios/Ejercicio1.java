package ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {
//Decidir si un árbol binario es equilibrado.
	public static void main(String[] args) {
		BinaryTree<Integer> t1 = BinaryTree.leaf(3);
		BinaryTree<Integer> t2 = BinaryTree.leaf(4);
		BinaryTree<Integer> t3 = BinaryTree.leaf(9);
		BinaryTree<Integer> t4 = BinaryTree.leaf(10);
		BinaryTree<Integer> tEqui = BinaryTree.binary(4, t1, t2);
		BinaryTree<Integer> tNoEqui = BinaryTree.binary(5, t1, BinaryTree.binary(7, BinaryTree.binary(6, t2, t4), t3));
		
		System.out.println(tNoEqui);
		System.out.println(tNoEqui.getRight().getHeight());
		System.out.println(tNoEqui.getLeft().getHeight());
		System.out.println(esEquilibrado(tNoEqui));
		
		System.out.println(tEqui);
		System.out.println(tEqui.getHeight());
		System.out.println(esEquilibrado(tEqui));
	}

	public static Boolean esEquilibrado(BinaryTree<Integer> t) {
		Boolean res = true;
		if (!t.isBinary() || t.isEmpty()) {
			return res;
		} else {
			Integer izq = t.getLeft().getHeight();
			Integer der = t.getRight().getHeight();
			if ((izq - der <= 1 && izq-der>=0)|| izq == der || (der - izq <= 1 && der-izq>=0)) {
				return esEquilibrado(t.getLeft()) && esEquilibrado(t.getRight());
			} else {
				return false;
			}
		}
	}

}
