package ejercicio1.BT;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.AlgoritmoBT;

public class TestProblemaUnoBT {
	public static void main(String[] args) {
		AlgoritmoBT.numeroDeSoluciones = 2;
		
		AlgoritmoBT.isRandomize = false;
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(11);
		numeros.add(8);
		numeros.add(10);
		numeros.add(6);
		numeros.add(5);
		numeros.add(2);
		numeros.add(3);
		numeros.add(1);
		numeros.add(1);
		numeros.add(1);
		
		ProblemaUno.setElementos(numeros);
		EstadoProblema1BT estadoInicial = EstadoProblema1BT.create();
		
		AlgoritmoBT<SolucionProblema1BT, Boolean, EstadoProblema1BT> alg = AlgoritmoBT.create(estadoInicial);
		
		alg.ejecuta();
		
		SolucionProblema1BT sol = alg.getSolucion();
		
		System.out.println(sol);
	}
}
