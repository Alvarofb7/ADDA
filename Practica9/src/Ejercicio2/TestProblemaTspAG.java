package Ejercicio2;

import java.util.List;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.grafos.datos.Ciudad;

public class TestProblemaTspAG {

	public static void main(String[] args) {
		setCondiciones();
		
		IndexProblemAG<List<Ciudad>> problem = new ProblemaTspAG("./ficheros/TSP.txt");
		AlgoritmoAG<IndexChromosome> alg = AlgoritmoAG.<IndexChromosome>create(ChromosomeType.IndexPermutation, problem);
		alg.ejecuta();
		
		IndexChromosome mejorSolucion = alg.getBestChromosome();
		System.out.println("============================================");
		System.out.println("Camino: " + problem.getSolucion(mejorSolucion));
		System.out.println("Coste: " + problem.fitnessFunction(mejorSolucion) * -1);
		System.out.println("============================================");
		
	}

	private static void setCondiciones() {
		// Condiciones "evolutivas"
		AlgoritmoAG.ELITISM_RATE = 0.2;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.5;
		AlgoritmoAG.POPULATION_SIZE = 300;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 3;
		StoppingConditionFactory.FITNESS_MIN = 0.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
	}

}
