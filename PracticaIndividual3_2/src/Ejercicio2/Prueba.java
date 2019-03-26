package Ejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Prueba {

	private static final Integer VM = 1; static Integer P=0;
	   
	public static void main(String[] args) {
		List<Tareas> t = cargarDatos("./ficheros/Ejercicio2_PL_b.txt");
//		List<Procesadores> p = cargarDatos2("./ficheros/procesadores.txt");
		String def = definirProblema(t);

		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("Valor resultante de la Función Objetivo: " + alg.getGoal());
		System.out.println("Valores variables: " + Arrays.toString(alg.getSolution()));
		
	}


	private static String definirProblema(List<Tareas> t) {
		String res = defFuncObj(t);
		res = res + resInvMax(t);
		res = res + restVbles(t);
		return res /*+= binario(t)*/;
	}

//	private static String binario(List<Tareas> t) {
//		return IntStream.range(0, t.size()).boxed().map(i->"x"+i).collect(Collectors.joining(",","bin: ", ";"));
//	}


	private static String restVbles(List<Tareas> t) {
		return IntStream.range(0, t.size()).boxed().map(i->"x" +P+ i+"<="+VM).collect(Collectors.joining(";\n","",";\n"));
	}

//	private static String num(List<Tareas> t) {
//		Integer c = 0;
//		Integer proc = 0;
//		String res = "";
//		while(proc<P) {
//			if(c<t.size()) {
//				res+="x" + proc.toString()+ c.toString();
//				c++;
//			}else {
//				res = res + "+";
//				c=0;
//				proc= proc + 1;
//				
//			}
//		}
//		return res ;
//	}
	
//	private static String procesador(List<Tareas> t, List<Procesadores> p) {
//		Integer c = 0;
//		Integer cp = 0;
//		String res ="";
//		if(c<t.size() && cp<p.size()) {
//			res += t.get(c).toString() + p.get(c).toString();
//			c++;
//		}else if(c==t.size()) {
//			cp++;
//			res+=t.get(c).toString() + p.get(c).toString();
//		}
//		return res;
//	}


	private static String resInvMax(List<Tareas> t) {
		return IntStream.range(0, t.size()).boxed().map(i->String.format("%dx%d%d", t.get(i).getDuracion(),P,i))
				.collect(Collectors.joining("+", "\n", "<=" + "T" + ";\n"));
	}

	private static String defFuncObj(List<Tareas> t) {
		return IntStream.range(0, t.size()).boxed().map(i -> String.format("%dx%d%d", t.get(i).getDuracion(),P,i))
				.collect(Collectors.joining("+", "min: ", ";\n"));
	}

	private static List<Tareas> cargarDatos(String f) {
		return Streams2.fromFile(f).map(Tareas::create).collect(Collectors.toList());
	}
//	private static List<Procesadores> cargarDatos2(String f) {
//		return Streams2.fromFile(f).map(Procesadores::create).collect(Collectors.toList());
//	}

}
