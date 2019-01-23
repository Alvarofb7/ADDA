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
		BinaryTree<Integer> t = BinaryTree.binary(6, BinaryTree.binary(4, BinaryTree.binary(3, t1,tv), t2),
				BinaryTree.binary(8, t3, t4));
		BinaryTree<Integer> tp = BinaryTree.binary(7, t1, t5);

		
		System.out.println("1º Arbol: " + t);
		System.out.println("2º Arbol: " + tp);
		
		System.out.println("Switch \n1º Arbol: " + estaOrdenado(t, true));
		System.out.println("2º Arbol: " + estaOrdenado(tp, true));
	}
		
	
	public static <E extends Comparable<E>> Boolean estaOrdenado(BinaryTree<E> arbol, Boolean res) {
		switch (arbol.getType()) {
			case Empty:
				break;
			case Leaf:
				break;
			case Binary:
				if(arbol.getLeft().isEmpty()) {
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

//	
//	public static <E extends Comparable<E>> Boolean ordenado(BinaryTree<E> arbol) {
//		List<E> ladoIzq = new ArrayList<>();
//		ladoIzq.add(arbol.getLabel());
//		List<E> ladoDer = new ArrayList<>();
//		ladoDer.add(arbol.getLabel());
//		return estaOrdenadoIzq(arbol.getLeft(), true, ladoIzq) && estaOrdenadoDer(arbol.getRight(), true, ladoDer);
//	}
//
//private static <E extends Comparable<E>> boolean estaOrdenadoDer(BinaryTree<E> arbol, boolean res, List<E> ladoDer) {
//	switch (arbol.getType()) {
//	case Empty:
//		break;
//	case Leaf:
//		if(ladoDer.get(0)!=null) {
//			ladoDer.add(arbol.getLabel());
//			if(ladoDer.get(0).compareTo(ladoDer.get(ladoDer.size()-1))>0) {
//				res = false;
//			}
//		}
//		break;
//	case Binary:
//		if(arbol.getLeft().isEmpty()) {
//			return estaOrdenadoDer(arbol.getRight(),
//					res && arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0, ladoDer);
//		}else if(arbol.getRight().isEmpty()) {
//			ladoDer.add(arbol.getLeft().getLabel());
//			return estaOrdenadoDer(arbol.getLeft(),
//					res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
//					&& ladoDer.get(0).compareTo(ladoDer.get(ladoDer.size()-1))<0
//					, ladoDer);
//		}else {
//			ladoDer.add(arbol.getLeft().getLabel());
//			return estaOrdenadoDer(arbol.getLeft(),
//					res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
//						&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0 
//						&& ladoDer.get(0).compareTo(ladoDer.get(ladoDer.size()-1))<0
//						, ladoDer)
//				&& estaOrdenadoDer(arbol.getRight(),
//						res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
//						&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0
//						, ladoDer);
//		}
//	}
//	return res;
//	}
//
//private static <E extends Comparable<E>> boolean estaOrdenadoIzq(BinaryTree<E> arbol, boolean res, List<E> ladoIzq) {
//	switch (arbol.getType()) {
//	case Empty:
//		break;
//	case Leaf:
//		if(ladoIzq.get(0)!=null) {
//			ladoIzq.add(arbol.getLabel());
//			if(ladoIzq.get(0).compareTo(ladoIzq.get(ladoIzq.size()-1))<0) {
//				res = false;
//			}
//		}
//		break;
//	case Binary:
//		if(arbol.getLeft().isEmpty()) {
//			ladoIzq.add(arbol.getRight().getLabel());
//			return estaOrdenadoIzq(arbol.getRight(), res && arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0
//					&& ladoIzq.get(0).compareTo(ladoIzq.get(ladoIzq.size()-1))>0
//					, ladoIzq);
//		}else if(arbol.getRight().isEmpty()) {
//			return estaOrdenadoIzq(arbol.getLeft(), res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) < 0, ladoIzq);
//		}else {
//			ladoIzq.add(arbol.getRight().getLabel());
//			return estaOrdenadoIzq(arbol.getLeft(),
//					res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
//						&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0 
//						, ladoIzq)
//				&& estaOrdenadoIzq(arbol.getRight(),
//					res && arbol.getLabel().compareTo(arbol.getLeft().getLabel()) > 0
//						&& arbol.getLabel().compareTo(arbol.getRight().getLabel()) < 0
//						&& ladoIzq.get(0).compareTo(ladoIzq.get(ladoIzq.size()-1))>0
//						, ladoIzq);
//		}
//	}
//	return res;
//} 
	
}
