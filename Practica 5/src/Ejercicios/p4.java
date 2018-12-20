package Ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class p4 {
//(EJ108): Obtener la copia simétrica de un árbol binario
	public static void main(String[] args) {
		BinaryTree<Integer> t1 = BinaryTree.leaf(4);
		BinaryTree<Integer> t2 = BinaryTree.leaf(7);
		BinaryTree<Integer> t = BinaryTree.binary(5, t1, t2);
		BinaryTree<Integer> tprueba = BinaryTree.binary(5, BinaryTree.binary(3, t1, t1), BinaryTree.binary(7, t2, t2));
		System.out.println(copiaSimetrica(t));
		System.out.println(copiaSimetrica(tprueba));
	}

	public static <E> BinaryTree<E> copiaSimetrica(BinaryTree<E> arbol){
		BinaryTree<E> res = null;
		switch(arbol.getType()) {
			case Empty:
				res = BinaryTree.empty();
				break;
			case Leaf:
				res = BinaryTree.leaf(arbol.getLabel());
			case Binary:
				res = BinaryTree.binary(arbol.getLabel(), copiaSimetrica(arbol.getRight()), copiaSimetrica(arbol.getLeft()));
		}
		return res;
	}
	
}
