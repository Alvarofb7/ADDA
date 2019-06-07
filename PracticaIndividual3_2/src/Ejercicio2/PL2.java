package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class PL2 {


	public static void main(String[] args) {
		List<String> tp = cargarDatos("./ficheros/PL2.txt");
		String def = definirProblema(tp);

		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));

	}

	private static String definirProblema(List<String> tp) {
		List<Tarea> tareas = getTareas(tp);
		Integer procesadores = getProcesadores(tp);

		String res = defFuncObj(tareas, procesadores);
		res += resEcuacMin(tareas, procesadores);
		res += restVbles(tareas, procesadores);
		res += restBin(tareas, procesadores);
		return res;
	}

	private static List<Tarea> getTareas(List<String> tp) {
		List<Tarea> l = new ArrayList<>();
		String[] array = tp.get(1).trim().split(",");
		for (int i = 0; i < array.length; i++) {
			l.add(Tarea.create(array[i]));
		}
		return l;
	}

	private static Integer getProcesadores(List<String> tp) {
		String[] array = tp.get(0).trim().split(",");
		Integer procesadores = array.length;
		return procesadores;
	}

	private static String defFuncObj(List<Tarea> t, Integer p) {
		String res = "min: T;\n";
		return res;
	}

	private static String resEcuacMin(List<Tarea> t, Integer p) {
		String res = "";
		Boolean first = true;
		for (int i = 0; i < p; i++) {
			first = true;
			for(int j = 0; j < t.size();j++) {
				if(first) {
					first = false;
				}else {
					res+= "+";
				}
				res+= String.format("%dx%d%d", t.get(j).getDuracion(),i,j);
			}
			res+= "<=T;\n";
		}
		return res;
	}

	private static String restVbles(List<Tarea> t, Integer p) {
		String res = "";
		Boolean first = true;
		for (int i = 0; i < t.size(); i++) {
			first = true;
			for (int j = 0; j < p; j++) {
				if (first) {
					first = false;
				} else {
					res += "+";
				}
				res += String.format("x%d%d", j, i);
			}
			res += "=1;\n";
		}
		return res;
	}

	private static String restBin(List<Tarea> t, Integer p) {
		String res = "bin ";
		Boolean first = true;
		for (int i = 0; i < p; i++) {
			first = true;
			for (int j = 0; j < t.size(); j++) {
				if (first) {
					first = false;
				} else {
					res += ",";
				}
				res += String.format("x%d%d", i, j);
			}
		}
		res += ";";
		return res;
	}

	private static List<String> cargarDatos(String fichero) {
		return Streams2.fromFile(fichero).collect(Collectors.toList());
	}
}