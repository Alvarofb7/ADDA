package ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {
//Decidir si un árbol binario es equilibrado.
	public static void main(String[] args) {
		BinaryTree<Integer> t1 = BinaryTree.leaf(3);
		BinaryTree<Integer> t2 = BinaryTree.leaf(4);
		BinaryTree<Integer> t3 = BinaryTree.leaf(9);
		BinaryTree<Integer> t4 = BinaryTree.leaf(10);
		BinaryTree<Integer> t = BinaryTree.binary(5, t1, BinaryTree.binary(7, BinaryTree.binary(6, t2, t4), t3));
		
		System.out.println(t);
		System.out.println(t.getRight().getHeight());
		System.out.println(t.getLeft().getHeight());
		System.out.println(esEquilibrado(t));
	}
//KUYKFYUK
//	public static Boolean esEquilibrado(BinaryTree<Integer> t) {
//		Boolean res = true;
//		if (!t.isBinary()) {
//			return res;
//		} else {
//			Integer izq = t.getLeft().getHeight();
//			Integer der = t.getRight().getHeight();
//			if (izq - der <= 1 || izq == der || der - izq <= 1) {
//				return esEquilibrado(t.getLeft()) && esEquilibrado(t.getRight());
//			} else {
//				return false;
//			}
//		}
//	}

	public static Boolean esEquilibrado(BinaryTree<Integer> t) {
			Integer nivelIzq = t.getLeft().getHeight();
			Integer nivelDer = t.getRight().getHeight();
			if(nivelDer-nivelIzq<=1 || nivelDer==nivelIzq || nivelIzq-nivelDer<=1) {
				return true;
			}else {
				return false;
			}
	}

}
