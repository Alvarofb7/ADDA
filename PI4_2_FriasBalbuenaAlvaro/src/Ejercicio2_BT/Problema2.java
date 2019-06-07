package Ejercicio2_BT;

import java.util.List;

public class Problema2 {

	public static List<Integer> elementos;
	
	public Problema2(List<Integer> elementos) {
		super();
		Problema2.elementos = elementos;
	}
	
	public List<Integer> getElementos(){
		return elementos;
	}
	
	public static void setElementos(List<Integer> elementos) {
		Problema2.elementos = elementos;
	}
//	EstadoProblema2BT b = EstadoProblema2BT.create(24);
}
