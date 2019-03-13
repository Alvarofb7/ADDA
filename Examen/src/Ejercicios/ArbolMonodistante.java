package Ejercicios;

import java.util.stream.IntStream;

import us.lsi.tiposrecursivos.Tree;

public class ArbolMonodistante {

	public static void main(String[] args) {
		 
	}

	public Boolean monoDistante(Tree<Integer> arbol, Integer orden) {
		return monoDistanteAux(arbol, orden, 0);
	}

	public Boolean monoDistanteAux(Tree<Integer> arbol, Integer orden, Integer ac) {
		Boolean ret;
		if (arbol.isEmpty()) {
			ret = (orden == ac);
		} else if (arbol.isLeaf()) {
			ret = (orden == (ac + arbol.getLabel()));
		} else {
			ret = IntStream.range(0, arbol.getNumOfChildren())
					.allMatch(i -> monoDistanteAux(arbol.getChild(i), orden, ac + arbol.getLabel()));
		}
		return ret;
	}
}
