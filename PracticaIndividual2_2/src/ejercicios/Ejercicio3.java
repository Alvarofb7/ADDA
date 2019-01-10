package ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {

	public static void main(String[] args) {
		BinaryTree<Integer> tv = BinaryTree.empty();
		BinaryTree<Integer> t1 = BinaryTree.leaf(2);
		BinaryTree<Integer> t2 = BinaryTree.leaf(5);
		BinaryTree<Integer> t3 = BinaryTree.leaf(7);
		BinaryTree<Integer> t4 = BinaryTree.leaf(9);
		BinaryTree<Integer> t5 = BinaryTree.leaf(4);
		BinaryTree<Integer> t = BinaryTree.binary(6, BinaryTree.binary(4, BinaryTree.binary(3, tv,t5), t2),
				BinaryTree.binary(8, t3, t4));
		BinaryTree<Integer> tp = BinaryTree.binary(7, t1, t5);

		System.out.println("1º Arbol: " + t);
		System.out.println("2º Arbol: " + tp);
		
		System.out.println("Switch \n1º Arbol2: " + estaOrdenado(t, true));
		System.out.println("2º Arbol2: " + estaOrdenado(tp, true));

	}

	public static <E extends Comparable<E>> Boolean estaOrdenado(BinaryTree<E> arbol, Boolean res) {
		switch (arbol.getType()) {
			case Empty:
				return res;
			case Leaf:
				return res;
			case Binary:
				if(arbol.getLeft().isEmpty() && arbol.getRight().isEmpty()){
					return res;	
				}else if(arbol.getLeft().isEmpty()) {
					return estaOrdenado(arbol.getRight(),
						res && arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0);
				} else if(arbol.getRight().isEmpty()) {
					return estaOrdenado(arbol.getLeft(),
						res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0);
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
	
}

//public static Boolean ordenado(BinaryTree<Integer> t) {
//Boolean res = null;
//switch (t.getType()) {
//case Empty:
//	res = true;
//	break;
//case Leaf:
//	res = true;
//	break;
//case Binary: 
//	if(t.getLabel()>t.getLeft().getLabel() && t.getLabel()<t.getRight().getLabel()) {
//		res = arbolOrdenado(t.getLeft()) && arbolOrdenado(t.getRight());
//	}else {
//		res = false;
//	}
//}
//return res;
//}