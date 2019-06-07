package ejercicio1.PDR;

import java.util.ArrayList;
import java.util.List;


import us.lsi.pd.AlgoritmoPD;

public class TestProblema1 {
	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.metricasOK = true;
		new DatosProblema1();
		
		Problema1PDR p = Problema1PDR.createInitial();
		
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		var sp = a.getSolucionParcial();
		if(sp != null) {
			System.out.println("Solucion: " + a.getSolucion());
		}else {
			System.out.println("Solucion no encontrada");
		}
		
	}
}
