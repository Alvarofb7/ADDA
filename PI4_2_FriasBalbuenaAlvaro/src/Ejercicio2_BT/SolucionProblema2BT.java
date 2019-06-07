package Ejercicio2_BT;

import java.util.List;

public class SolucionProblema2BT {
	public List<Integer> solucion;
	
	public SolucionProblema2BT(List<Integer> solucion) {
		this.solucion = solucion;
	}
	
	public static SolucionProblema2BT create(List<Integer> solucion) {
		return new SolucionProblema2BT(solucion);
	}
	
	public void add(Integer a, Boolean b) {
		if(b) {
			solucion.add(a);
		}
	}
	
	public void remove(Integer a, Boolean b) {
		if(!b) {
			solucion.remove(solucion.size()-1);
		}
	}
	
	public String toString() {
		return "Solución" + solucion;
	}
	
	public SolucionProblema2BT copy() {
		return new SolucionProblema2BT(solucion);
	}
}
