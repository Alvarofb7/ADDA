package Ejercicio2;

import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;


public class PL1 {

	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("./ficheros/PL1.txt");
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
		for (int i = 0; i < alg.getNumVar(); i++) {
			System.out.println(alg.getName(i)+" = "+alg.getSolution()[i]);
		}
  
	}

}
