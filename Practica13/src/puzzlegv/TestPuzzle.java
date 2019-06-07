package puzzlegv;

import java.util.function.BiFunction;

import org.jgrapht.Graphs;

import us.lsi.astar.AStarAlgorithm;
import us.lsi.graphs.SimpleEdge;

public class TestPuzzle {

	public static void main(String[] args) {

		VerticePuzzle.NUM_FILAS = 3;
		VerticePuzzle estadoInicial = VerticePuzzle.create(0, 1, 2, 3, 4, 5, 6, 7, 8);
		VerticePuzzle estadoFinal = VerticePuzzle.create(1, 2, 3, 4, 0, 5, 6, 7, 8);
		// TODO: EXPLICACION EN EL LABORATORIO
		
		var grafo = GrafoPuzzle.create(estadoInicial, estadoFinal);
		BiFunction<VerticePuzzle, VerticePuzzle, Double> heuristica = 
				(e1,e2) -> e1.getNumDiferentes(e2) - 1.;
				
		var alg = AStarAlgorithm.of(grafo, estadoInicial, estadoFinal, heuristica);
		
		
		System.out.println("Estado Inicial: " + estadoInicial);
		System.out.println("Estado Final: " + estadoFinal);
		
		System.out.println("Vértices del camino mínimo: ");
		alg.getPathVertexList().forEach(v-> System.out.println(v + "\n"));
		
		System.out.println("\nNúmero de movimientos: ");
		System.out.println(alg.getPath().getLength());
		
		System.out.println("\nVértices del estado inicial: ");
		var ss = grafo.edgesOf(estadoInicial);
		for(SimpleEdge<VerticePuzzle> simpleEdge : ss) {
			System.out.println(Graphs.getOppositeVertex(grafo, simpleEdge, estadoInicial));
		}
		
		
	}

}
