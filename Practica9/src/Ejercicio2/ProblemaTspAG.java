package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.GraphsReader;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

public class ProblemaTspAG implements IndexProblemAG<List<Ciudad>> {

	private Graph<Ciudad, Carretera> grafo;
	private List<Ciudad> ciudades;
	private static Double PESO_TOTAL;

	public ProblemaTspAG(String namef) {
		grafo = cargaGrafo(namef);
		ciudades = new ArrayList<>(grafo.vertexSet());
		PESO_TOTAL = grafo.edgeSet().stream().mapToDouble(Carretera::getKm).sum();
	}

	private Graph<Ciudad, Carretera> cargaGrafo(String namef) {
		Supplier<Graph<Ciudad, Carretera>> creator = () -> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create);

		return GraphsReader.newGraph(namef, Ciudad::create, Carretera::create, creator, Carretera::getKm);
	}

	@Override
	public Integer getObjectsNumber() {
		return grafo.vertexSet().size();
	}

	@Override
	public Double fitnessFunction(IndexChromosome cr) {
		List<Ciudad> sol = getSolucion(cr);
		return -sumaPesos(sol);
	}

	private Double sumaPesos(List<Ciudad> cities) {
		return IntStream.range(0, cities.size() - 1).boxed()
				.mapToDouble(i -> pesoArista(cities.get(i), cities.get(i + 1))).sum();
	}

	private Double pesoArista(Ciudad c1, Ciudad c2) {
		if (grafo.containsEdge(c1, c2))
			return grafo.getEdge(c1, c2).getKm();
		else
			return PESO_TOTAL;

	}

	@Override
	public List<Ciudad> getSolucion(IndexChromosome cr) {
		List<Integer> cromo = cr.decode();
		List<Ciudad> res = new ArrayList<>();
		for (Integer i : cromo) {
			res.add(ciudades.get(i));
		}
		res.add(res.get(0));
		return res;
	}

}
