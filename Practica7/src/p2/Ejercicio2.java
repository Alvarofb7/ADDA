package p2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio2 {
	private static final Integer MAX_INV = 65, VM = 1;
	
	public static void main(String[] args) {
		List<Oportunidad> escenario = cargarDatos("./ficheros/p2.txt");
		String def = definirProblema(escenario);
		
		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
	}

	private static String definirProblema(List<Oportunidad> escenario) {
		String res = defFuncObj(escenario);
		res = res + resInvMax(escenario);
		
		return res + restVbles(escenario.size());
	}

	private static String restVbles(int n) {
		return IntStream.range(0, n).boxed().map(i->"x"+i+"<="+VM)
				.collect(Collectors.joining(";\n","",";"));
	}

	private static String resInvMax(List<Oportunidad> lo) {
		return IntStream.range(0, lo.size()).boxed().map(i->String.format("%dx%d", lo.get(i).getCapital(),i))
				.collect(Collectors.joining("+", "", "<=" + MAX_INV + ";\n"));
	}

	private static String defFuncObj(List<Oportunidad> lo) {
		return IntStream.range(0, lo.size()).boxed().map(i->String.format("%dx%d", lo.get(i).getBeneficio(),i))
				.collect(Collectors.joining("+", "max: ", ";\n"));
	}
	
	private static List<Oportunidad> cargarDatos(String f) {
		return Streams2.fromFile(f).map(Oportunidad::create).collect(Collectors.toList());
	}

}
