package Ejercicio2_BT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.lsi.bt.EstadoBT;

public class EstadoProblema2BT implements EstadoBT<SolucionProblema2BT, Boolean,EstadoProblema2BT>{

	private List<Integer> numeros;
	private int index;
	private List<Integer> solucion;
	private Integer n;
	
	public List<Integer> ordenarLista(List<Integer> numeros){
		List<Integer> res = new ArrayList<>();
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		
		for(int i = 0; i< numeros.size(); i++) {
			if(numeros.get(i)%2==0) {
				pares.add(numeros.get(i));
			}else {
				impares.add(numeros.get(i));
			}
		}
		Collections.sort(pares);
		res.addAll(pares);
		res.addAll(impares);
		return res;
	}
	
	public EstadoProblema2BT(Integer index, List<Integer> solucion, Integer n) {
		super();
		ordenarLista(Problema2.elementos);
		this.numeros= Problema2.elementos;
		this.index = index;
		this.solucion = solucion;
		this.n = n;
	}
	
	public static EstadoProblema2BT create(Integer n) {
		return new EstadoProblema2BT(0, new ArrayList<Integer>(),n);
	}
	
	@Override
	public Tipo getTipo() {
		return Tipo.Max;
	}

	@Override
	public EstadoProblema2BT getEstadoInicial() {
		return EstadoProblema2BT.create(n);
	}

	@Override
	public EstadoProblema2BT avanza(Boolean a) {
		List<Integer> sol = new ArrayList<>(solucion);
		if(!a) {
			this.index++;
		}else {
			sol.add(numeros.get(index));
			this.index++;
		}
		this.solucion=sol;
		
		return this;
	}

	@Override
	public EstadoProblema2BT retrocede(Boolean a) {
		List<Integer> sol = new ArrayList<>(solucion);
		if(!a) {
			sol.remove(solucion.size()-1);
			this.index--;
		}else {
			this.index--;
		}
		
		return this;
	}

	@Override
	public int size() {
		return this.numeros.size() - this.index;
	}

	public Boolean sumaValida(List<Integer> numeros, Integer n) {
		Boolean res = false;
		Integer suma = 0;
		for(Integer i = 0; i<numeros.size();i++) {
			suma+=numeros.get(i);
		}
		if(suma<=n) {
			res = true;
		}
		return res;
	}
	
	private Integer sumaNumeros(List<Integer> ls) {
		 return ls.stream().mapToInt(i->i).sum();
	 }
	
	@Override
	public boolean esCasoBase() {
		return sumaNumeros(this.numeros)==n;
	}

	@Override
	public List<Boolean> getAlternativas() {
		List<Boolean> res = new ArrayList<>();
		if(sumaValida(numeros, n)) {
			res.add(true);
		}else {
			res.add(false);
		}
		return res;
	}

	@Override
	public SolucionProblema2BT getSolucion() {
		return SolucionProblema2BT.create(solucion);
	}

}
