package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3Defensa {

	public static void main(String[] args) {
		BinaryTree<Integer> tv = BinaryTree.empty();
		BinaryTree<Integer> t1 = BinaryTree.leaf(2);
		BinaryTree<Integer> t2 = BinaryTree.leaf(5);
		BinaryTree<Integer> t3 = BinaryTree.leaf(7);
		BinaryTree<Integer> t4 = BinaryTree.leaf(9);
		BinaryTree<Integer> t5 = BinaryTree.leaf(4);
		BinaryTree<Integer> t = BinaryTree.binary(6, BinaryTree.binary(4, BinaryTree.binary(3, t1, tv), t2),
				BinaryTree.binary(8, t3, t4));
		BinaryTree<Integer> tp = BinaryTree.binary(7, t1, t5);

		System.out.println("1º Arbol: " + t);
		System.out.println("2º Arbol: " + tp);

//		System.out.println("Switch \n1º Arbol: " + estaOrdenado(t, true));
//		System.out.println("2º Arbol: " + estaOrdenado(tp, true));
//		
		System.out.println(estaOrdenado(t));
		
		BinaryTree<Integer> td = BinaryTree.binary(10, BinaryTree.binary(8, t2, t5),
				BinaryTree.binary(9, t3, t4));
		System.out.println(td);
		System.out.println(estaOrdenado2(td, true));
	}

	public static Boolean estaOrdenado(BinaryTree<Integer> arbol, Boolean res) {
		switch (arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if (arbol.getLeft().isEmpty()) {
				return estaOrdenado(arbol.getRight(),
						res && arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0);
			} else if (arbol.getRight().isEmpty()) {
				return estaOrdenado(arbol.getLeft(), res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0);
			} else {
				return estaOrdenado(arbol.getLeft(),
						res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
								&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0)
						&& estaOrdenado(arbol.getRight(),
								res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
										&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0);
			}
		}
		return res;
	}

	public static List<Integer> estaOrdenado(BinaryTree<Integer> arbol) {
		List<Integer> res = new ArrayList<>();
		switch (arbol.getType()) {
		case Empty:
			break;
		case Leaf:  
			if (arbol.getLabel() % 2 == 0)
				res.add(arbol.getLabel());
			break;
		case Binary:
			if (arbol.getLabel() % 2 == 0)
				res.add(arbol.getLabel());
			res.addAll(estaOrdenado(arbol.getLeft()));
			res.addAll(estaOrdenado(arbol.getRight()));
		}

		return res;
	}

	public static Boolean estaOrdenado2(BinaryTree<Integer> arbol, Boolean res) {
		switch (arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if (arbol.getLeft().isEmpty()) {
				return estaOrdenado(arbol.getRight(),
						res && arbol.getLabel().compareTo(arbol.getRight().getLabel()) >= 0);
			} else if (arbol.getRight().isEmpty()) {
				return estaOrdenado(arbol.getLeft(), res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) >= 0);
			} else {
				return estaOrdenado(arbol.getLeft(),
						res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) >= 0
								&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) >= 0)
						&& estaOrdenado(arbol.getRight(),
								res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) >= 0
										&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) >= 0);
			}
		}
		return res;
	}
	
}
