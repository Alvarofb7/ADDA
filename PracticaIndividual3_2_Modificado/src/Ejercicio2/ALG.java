package Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class ALG implements ValuesInRangeProblemAG<Integer, List<Integer>>{
	
	
	public static Set<Procesador> procesadores;
	public static List<Tarea> tareas;
	
	public Integer getVariableNumber() {
		return procesadores.size()*tareas.size();
	}
	
	public Integer getMax(Integer i) {
		return 1;
	}
	
	public Integer getMin(Integer i) {
		return 0;
	}
	
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> ls = cr.decode();
		Double res = 0.0;
		Set<Integer> conj = new HashSet<>();
		List<Integer> aux = new ArrayList<>();
		for (int i = 0; i < procesadores.size(); i++) {
			Integer duracion = 0;
			for (int j = 0; j < tareas.size(); j++) {
				if(ls.get(tareas.size()*i + j) == 1) {
					duracion += tareas.get(j).getDuracion();
					conj.add(j);
				}
			}
			aux.add(duracion);
		}
		res += Collections.max(aux)+10*(tareas.size()-conj.size());
		return -res;
	}
	
	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		return cr.decode();
	}


}
	
