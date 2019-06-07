package Ejercicio2_BT;

import java.util.Arrays;
import java.util.List;

import us.lsi.bt.AlgoritmoBT;

public class TestProblema2BT {

	public static void main(String[] args) {
		AlgoritmoBT.numeroDeSoluciones = 1;
		
		AlgoritmoBT.isRandomize = false;
		
		List<Integer> numeros = Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		
		Problema2.setElementos(numeros);
		EstadoProblema2BT estadoInicial = EstadoProblema2BT.create(24);
		
		AlgoritmoBT<SolucionProblema2BT, Boolean, EstadoProblema2BT> alg = 
				AlgoritmoBT.create(estadoInicial);
		
		alg.ejecuta();
		
		SolucionProblema2BT sol = alg.getSolucion();
		
		System.out.println(sol);
		
	}
}
