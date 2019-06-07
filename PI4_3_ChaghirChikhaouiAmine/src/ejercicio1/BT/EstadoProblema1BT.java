package ejercicio1.BT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ejercicio1.BT.SolucionProblema1BT;
import us.lsi.bt.EstadoBT;

public class EstadoProblema1BT implements EstadoBT<SolucionProblema1BT,Boolean , EstadoProblema1BT>{

	private List<Integer> numeros;
	private int index;
	private List<Integer> conjUno;
	private List<Integer> conjDos;
	
	public EstadoProblema1BT(Integer index,List<Integer> conjUno, List<Integer> conjDos) {
		super();
		Collections.sort(ProblemaUno.elementos,Collections.reverseOrder());
		this.numeros =	ProblemaUno.elementos;
		this.index = index;
		this.conjUno = conjUno;
		this.conjDos = conjDos;
	}
	
	public static EstadoProblema1BT create() {
		return new EstadoProblema1BT(0,new ArrayList<Integer>(),new ArrayList<Integer>());
		
	}
	 private Integer suma(List<Integer> ls) {
		 return ls.stream().mapToInt(i->i).sum();
	 }
	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return Tipo.Min;
	}

	@Override
	public EstadoProblema1BT getEstadoInicial() {
		// TODO Auto-generated method stub
		return EstadoProblema1BT.create();
	}

	@Override
	public EstadoProblema1BT avanza(Boolean a) {
		List<Integer> conj1 = new ArrayList<>(conjUno);
		List<Integer> conj2 = new ArrayList<>(conjDos);
		
		if(!a) {
			conj2.add(numeros.get(index));
			this.index++;
			
		}else {
			conj1.add(numeros.get(index));
			this.index++;
		}
		this.conjUno = conj1;
		this.conjDos = conj2;
		
		return this;
	}

	@Override
	public EstadoProblema1BT retrocede(Boolean a) {
		List<Integer> conj1 = new ArrayList<>(conjUno);
		List<Integer> conj2 = new ArrayList<>(conjDos);
		
		if(a.equals(false) && !conj2.isEmpty()) {
			conj2.remove(conjDos.size()-1);
			this.index--;
		}else {
			if(!conj1.isEmpty()) {
				conj1.remove(conjUno.size()-1);
			}
			this.index--;
		}
		this.conjUno = conj1;
		this.conjDos = conj2;
		
		return this;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numeros.size() - this.index; 
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		return this.index == this.numeros.size();
	}

	@Override
	public List<Boolean> getAlternativas() {
		// TODO Auto-generated method stub
		List<Boolean> res = new ArrayList<>();
		if(esValido(index,conjUno)) {
			res.add(true);
		}else {
			res.add(false);
		}
		return res;
	}

	private boolean esValido(int index, List<Integer> conj) {
		// TODO Auto-generated method stub
		Integer tamConj = suma(numeros)/2; 
		return (tamConj - suma(conj))>=numeros.get(index);
	}

	@Override
	public SolucionProblema1BT getSolucion() {
		// TODO Auto-generated method stub
		return SolucionProblema1BT.create(conjUno,conjDos);
	}
	public Double getObjetivo() {
		Double n1 = (double) conjUno.size();
		Double n2 = (double) conjDos.size();
		return Math.min(n1, n2);
		
	}

}
