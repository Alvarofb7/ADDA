package Ejercicio;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.bt.EstadoBT;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class EstadoCaballo implements EstadoBT<SolucionCaballoBT, Integer, EstadoCaballo>{

	private Tuple2<Integer, Integer> posActual;
	private Map<Tuple2<Integer, Integer>, Integer> casillasProces;
	
	private EstadoCaballo() {
		posActual = ProbCab.posIni;
		casillasProces = new HashMap<>();
		casillasProces.put(posActual, 1);
	}
	
	public static EstadoCaballo create() {
		return new EstadoCaballo();
	}
	
	@Override
	public Tipo getTipo() {
		return EstadoBT.Tipo.AlgunasSoluciones;
	}

	@Override
	public EstadoCaballo getEstadoInicial() {
		return create();
	}

	@Override
	public EstadoCaballo avanza(Integer a) {    //a está en [0,7]
		posActual = Tuple.create(posActual.v1+ProbCab.movx[a], posActual.v2+ProbCab.movy[a]);
		casillasProces.put(posActual, casillasProces.size()+1);
		return this;
	}

	@Override
	public EstadoCaballo retrocede(Integer a) {
		casillasProces.remove(posActual);
		posActual = Tuple.create(posActual.v1-ProbCab.movx[a], posActual.v2-ProbCab.movy[a]);
		return this;
	}

	@Override
	public int size() {
		return (ProbCab.lado*ProbCab.lado)-casillasProces.size();
	}

	@Override
	public boolean esCasoBase() {
		return casillasProces.size()==Math.pow(ProbCab.lado, 2);
	}

	@Override
	public List<Integer> getAlternativas() {
		return IntStream.range(0, 8).boxed().filter(a->posValida(a) && posNueva(a)).collect(Collectors.toList());
	}

	private boolean posNueva(Integer a) {
		var pos = Tuple.create(posActual.v1+ProbCab.movx[a], posActual.v2+ProbCab.movy[a]);
		return casillasProces.get(pos)==null;
	}

	private boolean posValida(Integer a) {
		int i = posActual.v1+ProbCab.movx[a];  
		int j = posActual.v2+ProbCab.movy[a];
		return (i>=0) &&(i<ProbCab.lado) && (j>=0) && (j<ProbCab.lado);
	}
	
	@Override
	public SolucionCaballoBT getSolucion() {
		return SolucionCaballoBT.create(casillasProces);
	}

}
