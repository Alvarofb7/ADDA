package Ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class P1 {
//P1 - (EJ101) Suma de las etiquetas del árbol (binario / n-ario) que son pares
//	(asumiendo que son de tipo entero). (Java) 

	public static void main(String[] args) {
		BinaryTree<Integer> bt = BinaryTree.binary(1,
				BinaryTree.binary(2, BinaryTree.leaf(3), BinaryTree.empty()),
				BinaryTree.binary(3, BinaryTree.leaf(4), BinaryTree.empty()));
		
		Tree<Integer> t = Tree.nary(1, Tree.nary(2, Tree.leaf(3),Tree.empty())
				, Tree.nary(3, Tree.leaf(4), Tree.empty()));
		
		System.out.println(sumaPares(bt));
		System.out.println(sumaPares(t));
	}

	public static Integer sumaPares(BinaryTree<Integer> t) {
		Integer res = 0;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			break;
		case Binary:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			res = res + sumaPares(t.getLeft()) + sumaPares(t.getRight());
			break;
		}
		return res;
	}
	
	
	public static Integer sumaPares(Tree<Integer> t) {
		Integer res = 0;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			break;
		case Nary:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			res = res + t.getChildren().stream()
					.mapToInt(x->sumaPares(x))
					.sum();
			break;
		}
		return res;
	}
	
	
	
	
	
}
