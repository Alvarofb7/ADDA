package ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {
//Decidir si un árbol binario es equilibrado.
	public static void main(String[] args) {
		BinaryTree<Integer> t0 = BinaryTree.empty();
		BinaryTree<Integer> t1 = BinaryTree.leaf(3);
		BinaryTree<Integer> t2 = BinaryTree.leaf(4);
		BinaryTree<Integer> t3 = BinaryTree.leaf(9);
		BinaryTree<Integer> t4 = BinaryTree.leaf(10);
		BinaryTree<Integer> tEqui = BinaryTree.binary(4, t1, t2);
		BinaryTree<Integer> tPrueba = BinaryTree.binary(4, t0, t1);
		BinaryTree<Integer> tNoEqui = BinaryTree.binary(5, t1, BinaryTree.binary(7, BinaryTree.binary(6, t2, t4), t3));
		
		
		System.out.println("If Else\n" + "1º: " +tEqui);
//		System.out.println("Izq: " + tEqui.getLeft().getHeight());
//		System.out.println("Der: " + tEqui.getRight().getHeight());
		System.out.println("¿Arbol equilibrado?: " + esEquilibrado(tEqui));
		System.out.println("2º: " + tPrueba);
		System.out.println("¿Arbol equilibrado?: " + esEquilibrado(tPrueba));
		System.out.println("3º: " +  tNoEqui);
//		System.out.println("Izq: " + tNoEqui.getLeft().getHeight());
//		System.out.println("Der: " + tNoEqui.getRight().getHeight());
		System.out.println("¿Arbol equilibrado?: " + esEquilibrado(tNoEqui));
		
		System.out.println("Switch \n1º: " + tEqui);
		System.out.println("¿Arbol equilibrado?: " + equilibrado(tEqui));
		System.out.println("2º: " + tPrueba);
		System.out.println("¿Arbol equilibrado?: " + equilibrado(tPrueba));
		System.out.println("3º: " + tNoEqui);
		System.out.println("¿Arbol equilibrado?: " + equilibrado(tNoEqui));
	}
	
	//If Else
	public static Boolean esEquilibrado(BinaryTree<Integer> t) {
		Boolean res = true;
		if (!t.isBinary() || t.isEmpty()) {
			return res;
		} else {
			Integer izq = t.getLeft().getHeight();
			Integer der = t.getRight().getHeight();
			if ((izq - der <= 1 && izq - der >= 0) || izq == der || (der - izq <= 1 && der - izq >= 0)) {
				return esEquilibrado(t.getLeft()) && esEquilibrado(t.getRight());
			} else {
				return false;
			}
		}
	}
	
	//Switch
	public static Boolean equilibrado(BinaryTree<Integer> t) {
		Boolean res = null;
		switch (t.getType()) {
		case Empty:
			res = true;
			break;
		case Leaf:
			res = true;
			break;
		case Binary:
			Integer izq = t.getLeft().getHeight();
			Integer der = t.getRight().getHeight();
			if ((izq - der <= 1 && izq - der >= 0) || izq == der || (der - izq <= 1 && der - izq >= 0)) {
				res =  esEquilibrado(t.getLeft()) && esEquilibrado(t.getRight());
			} else {
				res = false;
			}
		}	
		return res;
	}

}
