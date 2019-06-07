package Ejercicio;
import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Tuple2;

public class SolucionCaballoBT {
	private Map<Tuple2<Integer, Integer>, Integer> tablero;

	public static SolucionCaballoBT create(Map<Tuple2<Integer, Integer>, Integer> t) {
		return new SolucionCaballoBT(t);
	}
	
	private SolucionCaballoBT(Map<Tuple2<Integer, Integer>, Integer> t) {
		tablero = new HashMap<>(t);
	}
	
	@Override
	public String toString() {
		int tam = ProbCab.lado;
		Integer[][] tab = new Integer[tam][tam];
		for(Tuple2<Integer, Integer> k: tablero.keySet()) {
			if(k.v1>=tam || k.v2>=tam)
				System.out.println("ERROR EN EL TABLERO");
			else
				tab[k.v1][k.v2] = tablero.get(k);
		}
		String res= "";
		for(int i=0;i<tam;i++) {
			for(int j=0;j<tam;tam++) {
				res+=String.format("%3d", tab[i][j]);
			}
			res+="\n";
		}
		return res;
	}
	
}

