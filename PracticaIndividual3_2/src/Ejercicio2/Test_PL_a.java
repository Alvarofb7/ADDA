package Ejercicio2;

import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;


public class Test_PL_a {

	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("./ficheros/Ejercicio2_PL_a.txt");
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
		

	}

}
