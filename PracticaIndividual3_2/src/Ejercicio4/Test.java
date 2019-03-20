package Ejercicio4;

import java.util.function.Supplier;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.graphs.EdgeArrayStringFactory;
import us.lsi.graphs.EdgeWeight;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.VertexArrayStringFactory;

public class Test {
	private static VertexArrayStringFactory<Monumento> factoriaVertices = Monumento::create;
	private static EdgeArrayStringFactory<Monumento, Camino> factoriaAristas = Camino::create;
	private static Supplier<Graph<Monumento,Camino>> factoriaGrafos = 
			() -> new SimpleWeightedGraph<Monumento,Camino>(Monumento::create, Camino::create);
	private static EdgeWeight<Camino> ew = Camino::getM;
	
	public static void main(String[] args) {
	Graph<Monumento, Camino> grafo = GraphsReader.newGraph("ficheros/andalucia.txt", factoriaVertices,
																						factoriaAristas,
																						factoriaGrafos,
																						ew);
	}
}
