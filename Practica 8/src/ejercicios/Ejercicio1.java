package ejercicios;


import java.io.PrintWriter;
import java.util.function.Supplier;

import org.jgrapht.Graph;


import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import us.lsi.common.Files2;
import us.lsi.graphs.EdgeArrayStringFactory;
import us.lsi.graphs.EdgeWeight;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.VertexArrayStringFactory;

public class Ejercicio1 {

	
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
		
		DOTExporter<Ciudad, Carretera> de = new DOTExporter<Ciudad,Carretera>(
				new IntegerComponentNameProvider<>(),
				vertice->vertice.getNombre(),
				arista->arista.getNombre()+String.format(" (%.1f kms)",arista.getKm()));
		
		PrintWriter pw = Files2.getWriter("ficheros/andalucia.gv"); //Del Proyecto Parte Comun
		de.exportGraph(grafo, pw);
				
		}
}
