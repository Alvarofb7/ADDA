package Ejercicios;

import us.lsi.tiposrecursivos.Tree;

//P1 – (EJ104): Determinar si un árbol n-ario contiene una etiqueta dada

public class p1 {

	public static void main(String[] args) {
		Tree<Integer> t1 = Tree.leaf(1);
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(3);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.nary(27, t1, t2, t3, t4);
		Tree<Integer> t = Tree.nary(39, t2, t5);
		System.out.println(t);
		System.out.println(etiqar(t, 2));
	}
	
	public static <E> Boolean etiqar(Tree<E> arbol, E etiqueta) {
		Boolean res = null;
		switch(arbol.getType()) {
		case Empty:
			res = false;
			break;
		case Leaf:
			res = arbol.getLabel().equals(etiqueta);
			break;
		case Nary:
			res = arbol.getLabel().equals(etiqueta) || 
			arbol.getChildren().stream().anyMatch(x -> etiqar(x, etiqueta));
		}
		
		return res;
	}

//	public static Boolean tieneEtiqueta(Tree<Integer> t, Integer etiqueta, Integer i) {
//		Boolean res = true;
//		if (t.getChildren() == null) {
//			return false;
//		} else {
//			if (t.getLabel() == etiqueta) {
//				return res;
//			} else {
//				if (i < t.size()) {
//					return tieneEtiqueta(t.getChild(i), etiqueta, i + 1);
//				}else {
//					if(t.getChild(i).getChildren()!=null) {
//						return tieneEtiqueta(t.getChild(i).getChild(i), etiqueta, i++);
//					}
//				}
//			}
//		}
//		return res;
//	}
}
