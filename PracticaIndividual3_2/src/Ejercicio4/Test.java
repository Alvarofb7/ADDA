package Ejercicio4;

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

public class Test {

	private static VertexArrayStringFactory<Monumento> factoriaVertices = Monumento::create;
	private static EdgeArrayStringFactory<Monumento, Camino> factoriaAristas = Camino::create;
	private static Supplier<Graph<Monumento,Camino>> factoriaGrafos = 
			() -> new SimpleWeightedGraph<Monumento,Camino>(Monumento::create, Camino::create);
	private static EdgeWeight<Camino> ew = Camino::getTiempo;
	
	public static void main(String[] args) {
		Graph<Monumento, Camino> grafo = GraphsReader.newGraph("ficheros/Monumentos.txt", factoriaVertices,
				factoriaAristas,
				factoriaGrafos,
				ew);
		
		DOTExporter<Monumento, Camino> de = new DOTExporter<Monumento, Camino>(
				new IntegerComponentNameProvider<>(),
				vertice->vertice.getNombre(),
				arista->arista.getTiempo()+String.format(" (%.1f mins)", arista.getTiempo()));
		
		PrintWriter pw = Files2.getWriter("ficheros/Monumentos.gv");
		de.exportGraph(grafo, pw);
	}

}
