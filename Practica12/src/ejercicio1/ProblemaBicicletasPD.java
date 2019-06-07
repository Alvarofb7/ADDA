package ejercicio1;

import java.util.Arrays;
import java.util.List;

import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class ProblemaBicicletasPD<V, E>
		implements ProblemaPD<String, ProblemaBicicletasPD.Alternativas, ProblemaBicicletasPD<V, E>> {

	public enum Alternativas {
		Yes, No
	};

	private Integer i;
	private Integer j;
	private Integer k;
	private GraphView<V, E> grafo;

	private ProblemaBicicletasPD(int i, int j, int k, GraphView<V, E> grafo) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
		this.grafo = grafo;

	}

	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, int k, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<V, E>(i, j, k, grafo);
	}

	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<V, E>(i, j, 0, grafo);
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return grafo.getNumVertices() - k;
	}

	@Override
	public boolean esCasoBase() {
		return i == j || k == grafo.getNumVertices();
	}

	@Override
	public Sp<Alternativas> getSolucionParcialCasoBase() {
		Sp<Alternativas> res = null;
		if(i==j) {
			res = Sp.<Alternativas>create(Alternativas.No,0.0);
		} else if(grafo.isEdge(i, j)) {
			Double peso = grafo.getWeight(i, j);
			res = Sp.<Alternativas>create(Alternativas.No,peso);
		} else {
			res = null;
		}
		return res;
	}

	@Override
	public ProblemaBicicletasPD<V, E> getSubProblema(Alternativas a, int np) {
		ProblemaBicicletasPD<V, E> res = null;
		switch (a) {
		case No:
			res = ProblemaBicicletasPD.create(i, j, k + 1, grafo);
			break;
		case Yes:
			switch (np) {
			case 0:
				res = ProblemaBicicletasPD.create(i, k, k + 1, grafo);
				break;
			case 1:
				res = ProblemaBicicletasPD.create(k, j, k + 1, grafo);
				break;
			default:
				throw new IllegalArgumentException("El nº del subproblema no puede ser " + np);
			}
			break;
		}

		return res;
	}

	@Override
	public Sp<Alternativas> getSolucionParcialPorAlternativa(Alternativas a, List<Sp<Alternativas>> ls) {
		Sp<Alternativas> res = Sp.create(a, ls.get(0).propiedad);
		switch (a) {
		case No:
			break;
		case Yes:
			res.propiedad += ls.get(1).propiedad;
			break;
		}
		return res;
	}

	@Override
	public List<Alternativas> getAlternativas() {
		List<Alternativas> res = null;
		if (i == k || k == j) {
			res = Arrays.asList(Alternativas.No);
		} else {
			res = Arrays.asList(Alternativas.values());
		}
		return res;
	}

	@Override
	public int getNumeroSubProblemas(Alternativas a) {
		return a.equals(Alternativas.No) ? 1 : 2;
	}

	@Override
	public String getSolucionReconstruidaCasoBase(Sp<Alternativas> sp) {
		return grafo.getVertice(i) + "<" + sp.propiedad + ">" + grafo.getVertice(j);
	}

	@Override
	public String getSolucionReconstruidaCasoRecursivo(Sp<Alternativas> sp, List<String> ls) {
		String res = "";
		switch (sp.alternativa) {
		case No:
			res = ls.get(0);
			break;
		case Yes:
			res = ls.get(0) + ", " + ls.get(1);
			break;
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grafo == null) ? 0 : grafo.hashCode());
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((j == null) ? 0 : j.hashCode());
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProblemaBicicletasPD<V, E> other = (ProblemaBicicletasPD<V, E>) obj;
		if (grafo == null) {
			if (other.grafo != null)
				return false;
		} else if (!grafo.equals(other.grafo))
			return false;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		return true;
	}

}
