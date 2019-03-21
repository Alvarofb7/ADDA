package ejercicios;


import java.util.function.Supplier;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.SimpleWeightedGraph;



import us.lsi.graphs.EdgeArrayStringFactory;
import us.lsi.graphs.EdgeWeight;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.VertexArrayStringFactory;

public class Ejercicio2 {
	
	private static VertexArrayStringFactory<Ciudad> factoriaVertices = Ciudad::create;
	private static EdgeArrayStringFactory<Ciudad, Carretera> factoriaAristas = Carretera::create;
	private static Supplier<Graph<Ciudad,Carretera>> factoriaGrafos = 
			() -> new SimpleWeightedGraph<Ciudad,Carretera>(Ciudad::create, Carretera::create);
	private static EdgeWeight<Carretera> ew = Carretera::getKm;
	
	public static void main(String[] args) {
	Graph<Ciudad, Carretera> grafo = GraphsReader.newGraph("ficheros/andalucia.txt", factoriaVertices,
																						factoriaAristas,
																						factoriaGrafos,
																						ew);
	String[] orig = {"Huelva","230466.0"};
	String[] dest = {"Almeria","257207.0"};
	Ciudad origen = Ciudad.create(orig);
	Ciudad destino = Ciudad.create(dest);
	caminoMinimo(grafo, origen, destino);
	recubrimientoMaximo(grafo);
	
	}
	private static void caminoMinimo(Graph<Ciudad, Carretera>grafo, Ciudad origen,Ciudad destino) {
		ShortestPathAlgorithm<Ciudad, Carretera> algoritmo = new DijkstraShortestPath<Ciudad,Carretera>(grafo);
		GraphPath<Ciudad, Carretera> gp = algoritmo.getPath(origen, destino);
		Double distancia = algoritmo.getPathWeight(origen, destino);
		System.out.println(String.format("\nCamino mas corto entre Huelva y Almeria es: "+distancia.intValue()+" kms"));
		System.out.println("\tCarreteras: "+gp);
		//System.out.println("\tCiudades: "+gp.getVertexList());
			
	}
	
	private static void recubrimientoMaximo(Graph<Ciudad, Carretera> grafo) {
		SpanningTreeAlgorithm<Carretera> algoritmo = new KruskalMinimumSpanningTree<>(grafo);
		SpanningTree<Carretera> sp = algoritmo.getSpanningTree();
		
		System.out.println(String.format("\nConexion de todas las ciudades con nº de Kilometros: "+sp.getWeight()));
		System.out.println("\tCarreteras: "+sp.getEdges());
	}
	
}
