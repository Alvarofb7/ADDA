package ejercicio4;

import us.lsi.pd.AlgoritmoPD;

public class TestProblemaCuatroPD {
	
	
		public static void main(String[] args) {
			AlgoritmoPD.isRandomize = false;
		
			String cadena = "ababbbabbababa";
			
			ProblemaCuatroPD p = ProblemaCuatroPD.create(cadena, 0, cadena.length());
			
			
			var a = AlgoritmoPD.createPD(p);
			a.ejecuta();
			
			
			System.out.println("Solucion: "+a.getSolucion());
			
			

		}
	
}
