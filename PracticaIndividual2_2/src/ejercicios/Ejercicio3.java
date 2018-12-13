package ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {

	public static void main(String[] args) {
		BinaryTree<Integer> t1 = BinaryTree.leaf(2);
		BinaryTree<Integer> t2 = BinaryTree.leaf(5);
		BinaryTree<Integer> t3 = BinaryTree.leaf(7);
		BinaryTree<Integer> t4 = BinaryTree.leaf(9);
		BinaryTree<Integer> t5 = BinaryTree.leaf(4);
		BinaryTree<Integer> t = BinaryTree.binary(6,BinaryTree.binary(4,BinaryTree.binary(3,t1,t5),t2),BinaryTree.binary(8,t3,t4));
		BinaryTree<Integer> tp = BinaryTree.binary(3,t1, t5);
		System.out.println(arbolOrdenado(t));
		System.out.println(arbolOrdenado(tp));
	}
	//label = coger el padre
	public static Boolean arbolOrdenado(BinaryTree<Integer> t) {
		Boolean res = true;
		if(!t.isBinary()) {
			return res;
		}else {
			if(t.getLabel()>t.getLeft().getLabel() && t.getLabel()<t.getRight().getLabel()) {
				return arbolOrdenado(t.getLeft()) && arbolOrdenado(t.getRight());
			}else {
				return false;
			}
		}
	}
	
}
