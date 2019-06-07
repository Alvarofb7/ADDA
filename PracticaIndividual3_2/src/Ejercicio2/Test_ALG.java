package Ejercicio2;

import java.util.List;
import java.util.Set;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class Test_ALG {
	
	public static void main(String[] args) {
		Set<Procesador> lp = Procesador_ALG.crearProcesador("ficheros/Procesador.txt");
		List<Tarea> lt = Tarea_ALG.crearTareaFichero("ficheros/Tareas.txt");
		
		ALG.procesadores = lp;
		ALG.tareas = lt;
	
		setConstantes();
		
		ValuesInRangeProblemAG<Integer, List<Integer>> p = new ALG();
		var ap = AlgoritmoAG.<ValuesInRangeChromosome<Integer>> create(
				ChromosomeFactory.ChromosomeType.Binary,p);
		ap.ejecuta();
		
		ValuesInRangeChromosome<Integer> cr = ap.getBestChromosome();
		System.out.println("==============================================================");
		System.out.println("Mejor cromosoma: " + p.getSolucion(cr)
		+ "; " + "Fitness:" + cr.fitness());
		System.out.println("==============================================================");
	}

	private static void setConstantes() {
		AlgoritmoAG.ELITISM_RATE = 0.3;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;
		
		StoppingConditionFactory.stoppingConditionType = 
				StoppingConditionType.GenerationCount;
		StoppingConditionFactory.NUM_GENERATIONS = 10000;
		
		ChromosomeFactory.crossoverType = 
				ChromosomeFactory.crossoverType.OnePoint;
	}

}
