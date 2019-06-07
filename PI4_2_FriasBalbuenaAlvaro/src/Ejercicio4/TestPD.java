package Ejercicio4;

import us.lsi.pd.AlgoritmoPD;

public class TestPD {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;
		
		//Creo la cadena
		String cadena = "ababbbabbababa";
		
		//Creo un Palindromo con la cadena y los 2 integer
		Palindromo p = Palindromo.create(cadena, 0, cadena.length());
		
		//Creo AlgoritmoPD con el Palindromo
		var a = AlgoritmoPD.createPD(p);
		a.ejecuta();
		
		//Muestro resultados
		System.out.println("Solución: " + a.getSolucion());
	}

}
