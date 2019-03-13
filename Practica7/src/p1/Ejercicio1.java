package p1;

import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio1 {

	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("./ficheros/p1.txt");
		System.out.println("Valor resultante de la Funci�n Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
		
	}

}
