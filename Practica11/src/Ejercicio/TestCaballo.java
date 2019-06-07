package Ejercicio;
import us.lsi.bt.AlgoritmoBT;
import us.lsi.common.Tuple;

public class TestCaballo {

	public static void main(String[] args) {
		ProbCab.lado = 6;
		ProbCab.posIni = Tuple.create(1, 1);
		
		EstadoCaballo estadoInicial = EstadoCaballo.create();
		
		var alg = AlgoritmoBT.create(estadoInicial);
		AlgoritmoBT.numeroDeSoluciones=10;
		alg.ejecuta ();
	
		for(SolucionCaballoBT sol: alg.getSoluciones()) {
			System.out.println(sol);
		}
	}
}
