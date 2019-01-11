package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class P2 {
//P2 - (EJ116) Convertir un árbol binario en una lista que contiene sus etiquetas en
//	recorrido en posorden. En este recorrido se añade primero las etiquetas de su hijo
//	izquierdo, luego las del derecho y por último la etiqueta del árbol actual. (Java) 

	public static void main(String[] args) {

		BinaryTree<String> bt = BinaryTree.binary("A",
				BinaryTree.binary("Z",
						BinaryTree.leaf("H"), 
						BinaryTree.empty()),
				BinaryTree.binary("T",
						BinaryTree.leaf("B"),
						BinaryTree.leaf("C")));

		System.out.println("PosOrden de " + bt + " = " + recorridoPosOrden(bt));
	}

	private static <E> List<E> recorridoPosOrden(BinaryTree<E> bt) {
		List<E> res = new ArrayList<>();
		switch (bt.getType()) {
			case Empty:
				break;
			case Leaf:
				res.add(bt.getLabel());
				break;
			case Binary:
				res.addAll(recorridoPosOrden(bt.getLeft()));
				res.addAll(recorridoPosOrden(bt.getRight()));
				res.add(bt.getLabel());
				break;
		}
		return res;
	}
	
//	private static <E> List<E> recorridoPosOrden(Tree<E> t) {
//		List<E> res = new ArrayList<>();
//		switch (t.getType()) {
//			case Empty:
//				break;
//			case Leaf:
//				res.add(t.getLabel());
//				break;
//			case Nary:
//				res.add(t.getChildren().stream().map(x->(string) recorridoPosOrden(x)));
//				res.add(t.getLabel());
//				break;
//		}
//		return res;
//	}

}
