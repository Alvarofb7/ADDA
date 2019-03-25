package Ejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Test_PL_b {

	private static final Integer VM = 1;
	
	public static void main(String[] args) {
		List<Tareas> t = cargarDatos("./ficheros/Ejercicio2_PL_b.txt");
		List<Procesadores> p = cargarDatos2("./ficheros/procesadores.txt");
		String def = definirProblema(t,p);

		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
	}

	private static String definirProblema(List<Tareas> t, List<Procesadores> p) {
		String res = defFuncObj(t,p);
		res = res + resInvMax(t,p);
		return res + restVbles(t.size(), p.size());
	}

	private static String restVbles(int t, int p) {
		return IntStream.range(0, t).boxed().map(mapper);
	}

	private static String resInvMax(List<Tareas> t, List<Procesadores> p) {

		return null;
	}

	private static String defFuncObj(List<Tareas> t, List<Procesadores> p) {
		return IntStream.range(0, t.size()).boxed().map(i -> String.format("%dx%d%d", t.get(i).getDuracion(),p.get(0), i))
				.collect(Collectors.joining("+", "min: ", ";/n"));
	}

	private static List<Tareas> cargarDatos(String f) {
		return Streams2.fromFile(f).map(Tareas::create).collect(Collectors.toList());
	}
	private static List<Procesadores> cargarDatos2(String f) {
		return Streams2.fromFile(f).map(Procesadores::create).collect(Collectors.toList());
	}


}
