package ejercicio1.GrafosVirtuales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class VertexElement implements VirtualVertex<VertexElement, SimpleEdge<VertexElement>> {
	private List<Integer> datos;
	private List<Integer> C1;
	private List<Integer> C2;
	private int indice;

	public VertexElement(List<Integer> datos) {
		Collections.sort(datos, Collections.reverseOrder());
		this.datos = datos;
		this.C1 = new ArrayList<>();
		this.C2 = new ArrayList<>();
		this.indice = 0;

	}

	public VertexElement(List<Integer> datos, List<Integer> C1, List<Integer> C2, int indice) {
		this.datos = datos;
		this.C1 = C1;
		this.C2 = C2;
		this.indice = indice;

	}

	@Override
	public boolean isValid() {
		return datos.size() > indice;
	}

	@Override
	public Set<VertexElement> getNeighborListOf() {
		Set<VertexElement> res = new HashSet<>();
		if (isValid(this.indice, this.C1)) {
			List<Integer> copiaC1 = new ArrayList<>(C1);
			copiaC1.add(datos.get(this.indice));
			this.indice++;
			VertexElement v1 = new VertexElement(this.datos, copiaC1, this.C2, this.indice);
			res.add(v1);
		} else {
			List<Integer> copiaC2 = new ArrayList<>(C2);
			copiaC2.add(datos.get(this.indice));
			this.indice++;
			VertexElement v2 = new VertexElement(this.datos, this.C1, copiaC2, this.indice);
			res.add(v2);
		}
		return res;

	}

	@Override
	public Set<SimpleEdge<VertexElement>> edgesOf() {
		return getNeighborListOf().stream().map(x -> SimpleEdge.of(this, x)).collect(Collectors.toSet());
	}

	public List<Integer> getDatos() {
		return datos;
	}

	public void setDatos(List<Integer> datos) {
		this.datos = datos;
	}

	public List<Integer> getC1() {
		return C1;
	}

	public void setC1(List<Integer> c1) {
		C1 = c1;
	}

	public List<Integer> getC2() {
		return C2;
	}

	public void setC2(List<Integer> c2) {
		C2 = c2;
	}

	@Override
	public String toString() {
		return "Conjunto Uno=" + C1 + " Conjunto Dos=" + C2+"\n";
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	private boolean isValid(int index, List<Integer> C) {
		Integer tamanio = this.datos.stream().mapToInt(i -> i).sum() / 2;
		Integer res = tamanio - C.stream().mapToInt(i -> i).sum();
		return res >= datos.get(index);
	}

}