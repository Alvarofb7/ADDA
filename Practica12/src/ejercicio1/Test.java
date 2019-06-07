package ejercicio1;

import tipos.Calle;
import tipos.Estacion;
import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD;

public class Test {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;

		// Instancia problemaBicicletas
		ProblemaBicicletas g = ProblemaBicicletas.create("ficheros/mapa.txt");

		// Creo grafo
		GraphView<Estacion, Calle> gv = GraphView.create(g.getGrafo());

		// Creo origen y destino preguntando a grafo cúal es su índice
		Integer origen = gv.getIndex(new Estacion("Estacion0"));
		Integer destino = gv.getIndex(new Estacion("Estacion3"));

		// Instancio ProblemaBicicletaPD con origen, destino y grafo
		ProblemaBicicletasPD<Estacion, Calle> p = ProblemaBicicletasPD.create(origen, destino, gv);

		// Creo algoritmo en base a ProblemaBicicletaPD
		var a = AlgoritmoPD.createPD(p);
		a.ejecuta();

		// Ejecuto algoritmo y muestro resultados
		System.out.println("Solución: " + a.getSolucion(p));
		a.showAllGraph("ficheros/solucion.gv", "Solución", p);

	}

}
