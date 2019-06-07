package Ejercicio4;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.WeightedMultigraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import us.lsi.common.Files2;
import us.lsi.graphs.EdgeArrayStringFactory;
import us.lsi.graphs.EdgeWeight;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.VertexArrayStringFactory;

public abstract class Test_Ejercicio4 {

	private static VertexArrayStringFactory<Monumento> factoriaVertices = Monumento::create;
	private static EdgeArrayStringFactory<Monumento, Camino> factoriaAristas = Camino::create;
	// Grafo Simple
	private static Supplier<Graph<Monumento, Camino>> supplierGrafos = () -> new WeightedMultigraph<Monumento, Camino>(
			Monumento::create, Camino::create);
	private static EdgeWeight<Camino> ew = Camino::getTiempo;

	// Grafo Dirigido sin Peso
	private static Supplier<Graph<Monumento, Camino>> supplierGrafosDirigidoSinPeso = () -> new DirectedMultigraph<Monumento, Camino>(
			Camino.class);

	// Grafo Dirigido con Peso
	private static Supplier<Graph<Monumento, Camino>> supplierGrafosDirigido = () -> new DirectedWeightedMultigraph<Monumento, Camino>(
			Monumento::create, Camino::create);

	public static void main(String[] args) {
		// Grafo Simple
		Graph<Monumento, Camino> grafo = GraphsReader.newGraph("ficheros/Grafo.txt", factoriaVertices, factoriaAristas,
				supplierGrafos, ew);
		// Grafo Dirigido sin Peso
		Graph<Monumento, Camino> grafoDirigidoSinPeso = GraphsReader.newGraph("ficheros/GrafoDirigido.txt",
				factoriaVertices, factoriaAristas, supplierGrafosDirigidoSinPeso);
		// Grafo Dirigido con Peso
		Graph<Monumento, Camino> grafoDirigido = GraphsReader.newGraph("ficheros/Grafo.txt", factoriaVertices,
				factoriaAristas, supplierGrafosDirigido, ew);

		// Genera el Grafo.gv
		DOTExporter<Monumento, Camino> de = new DOTExporter<Monumento, Camino>(new IntegerComponentNameProvider<>(),
				vertice -> vertice.getNombre(), arista -> String.format(" (%.1f mins)", arista.getTiempo()));

		PrintWriter pw = Files2.getWriter("ficheros/Grafo.gv");
		de.exportGraph(grafo, pw);

		// Genera el GrafoDirigido.gv
		DOTExporter<Monumento, Camino> ded = new DOTExporter<Monumento, Camino>(new IntegerComponentNameProvider<>(),
				vertice -> vertice.getNombre(), arista -> String.format(" (%.1f mins)", arista.getTiempo()));

		PrintWriter pwd = Files2.getWriter("ficheros/GrafoDirigido.gv");
		ded.exportGraph(grafoDirigido, pwd);

		System.out.println("----------Solución A----------");
		System.out.println("¿Están todos los monumentos conectados entre sí?");
		esConexo(grafo);

		System.out.println("----------Solución B----------");
		System.out.println("Monumentos que pueden visitarse sin haber visitado otros antes: ");
		recubrimientoMinimo(grafoDirigidoSinPeso);

		System.out.println("----------Solución C----------");
		Monumento origen = Monumento.create("Monumento0");
		Monumento destino = Monumento.create("Monumento8");
		System.out.println("Los datos del camino entre " + origen + " y " + destino + " son:");
		subconjunto(grafo, origen, destino);

		System.out.println("-----------Ejercicios Defensa------------");
		System.out.println("Ejercicio1");
		System.out.println("La media de tiempo de todos los caminos es: " + media(grafo));
		
		Monumento principal = Monumento.create("Monumento2");
		Double tiempo = 12.0;
		System.out.println("\nEjercicio2");
		System.out.println("Monumentos que se pueden visitar desde " + principal + " en " + tiempo + " minutos son :");
		System.out.println(Lugares(grafo, principal, tiempo));
		
		System.out.println("\nEjercicio3");
		tiempoParaLlegar(grafo,tiempo,principal);
	
	}

	private static void tiempoParaLlegar(Graph<Monumento, Camino> grafo2, double d, Monumento c1) {
		ConnectivityInspector<Monumento, Camino> alg = new ConnectivityInspector<Monumento, Camino>(grafo2);
		DijkstraShortestPath<Monumento, Camino> cam = new DijkstraShortestPath<>(grafo2);
		Set<Monumento> comp = alg.connectedSetOf(c1);
		
		List<Monumento> res2 = new ArrayList<Monumento>();
		comp.remove(c1);
		res2=comp.stream().collect(Collectors.toList());
		for (int i = 0; i < comp.size(); i++) {
			Monumento s = res2.get(i);
			if (cam.getPath(c1, s).getEdgeList().stream().mapToDouble(x -> x.getTiempo()).sum() < d) {

				System.out.println("Con "+ d + " minutos de tiempo, puedes visitar el monumento: "+s.getNombre());
			}
			
		}

	}
	
	
	private static List<Monumento> Lugares(Graph<Monumento, Camino> grafo, Monumento principal, Double tiempo) {
		List<Monumento> res = new ArrayList<>();
		List<Monumento> monumentos = grafo.vertexSet().stream().collect(Collectors.toList());
		Integer i = 0;
		while (i < monumentos.size()) {
			if(grafo.containsEdge(principal,monumentos.get(i)) || grafo.containsEdge(monumentos.get(i),principal)) {
				System.out.println("--------------");
				System.out.println("Hay camino entre " + principal + " y " + monumentos.get(i));
				if(grafo.getEdge(principal, monumentos.get(i)).getTiempo()<tiempo) {
					res.add(monumentos.get(i));
					System.out.println(monumentos.get(i) + " está dentro del rango de tiempo");
					System.out.println("--------------");
				}else {
					System.out.println(monumentos.get(i) + " NO está dentro del rango de tiempo");
				}
			}else {
				System.out.println("No hay camino entre " + principal + " y " + monumentos.get(i));
			}
			i++;
		}
		return res;
	}

	private static Double media(Graph<Monumento, Camino> grafo) {
		List<Camino> lista = grafo.edgeSet().stream().collect(Collectors.toList());
		Double res = lista.stream().mapToDouble(i -> i.getTiempo()).sum();
		Double media = res / lista.size();
		return media;
	}

	private static void esConexo(Graph<Monumento, Camino> grafo) {
		ConnectivityInspector<Monumento, Camino> sol = new ConnectivityInspector<Monumento, Camino>(grafo);
		Boolean res = sol.isConnected();
		if (res == true) {
			System.out.println("Sí.El grafo es conexo.");
		} else {
			System.out.println("No. El grafo no es conexo. Las componentes conexas son: " + sol.connectedSets());
		}
	}

	private static void recubrimientoMinimo(Graph<Monumento, Camino> grafoDirigidoSinPeso) {
		Set<Monumento> res = grafoDirigidoSinPeso.vertexSet().stream()
				.filter(x -> grafoDirigidoSinPeso.incomingEdgesOf(x).isEmpty()).collect(Collectors.toSet());
		System.out.println(res);

	}

	private static void subconjunto(Graph<Monumento, Camino> grafo, Monumento origen, Monumento destino) {
		Graph<Monumento, Camino> grafoDirigido = GraphsReader.newGraph("ficheros/GrafoDirigido.txt", Monumento::create,
				Camino::create,
				() -> new DirectedWeightedMultigraph<Monumento, Camino>(Monumento::create, Camino::create),
				Camino::getTiempo);
		DijkstraShortestPath<Monumento, Camino> cmg = new DijkstraShortestPath<>(grafo);
		DijkstraShortestPath<Monumento, Camino> cmgd = new DijkstraShortestPath<>(grafoDirigido);
		Double tiempo = 0.;
		if (cmg.getPath(origen, destino) != null && cmgd.getPath(origen, destino) != null) {
			System.out.println("Se cumple la precedencia, asi que: ");
			System.out.println("El camino minimo desde " + origen + " hasta " + destino + " es: ");
			for (int i = 0; i < cmgd.getPath(origen, destino).getVertexList().size() - 1; i++) {
				Monumento origen1 = cmgd.getPath(origen, destino).getVertexList().get(i);
				Monumento destino1 = cmgd.getPath(origen, destino).getVertexList().get(i + 1);
				System.out.println(cmgd.getPath(origen1, destino1));
				tiempo += cmg.getPathWeight(origen1, destino1);
			}
			System.out.println("Tiempo empleado: " + tiempo + " min");
		} else {
			System.out.println("No existe un camino que una los dos certices cumpliendo la precedencia.");
		}
	}

}
