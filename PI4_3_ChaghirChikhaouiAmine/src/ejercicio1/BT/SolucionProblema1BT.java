package ejercicio1.BT;

import java.util.List;

public class SolucionProblema1BT {
	public List<Integer> conj1;
	public List<Integer> conj2;
	public SolucionProblema1BT(List<Integer> conjUno, List<Integer> conjDos) {
		this.conj1 = conjUno;
		this.conj2 = conjDos;
	}
	public static SolucionProblema1BT create(List<Integer> conjUno, List<Integer> conjDos) {
	
		return new SolucionProblema1BT(conjUno, conjDos);
	}
	public void add(Integer a, Boolean b) {
		if(b) {
			conj1.add(a);
		}else {
			conj2.add(a);
		}
	}
	public void remove(Integer a, Boolean b) {
		if(b) {
			conj1.remove(conj1.size()-1);
		}else {
			conj2.remove(conj2.size()-1);
		}
	}
	
	public String toString() {
		return "Conjunto Uno: "+conj1+"\nConjunto Dos: "+conj2;
	}
	
	public SolucionProblema1BT copy() {
		return new SolucionProblema1BT(conj1, conj2);
	}
}
