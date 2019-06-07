package puzzlegv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class VerticePuzzle implements VirtualVertex<VerticePuzzle, SimpleEdge<VerticePuzzle>> {

	public static Integer NUM_FILAS = 3;

	private Integer x0, y0;
	private Integer[][] datos;

	public static VerticePuzzle create(Integer... d) {
		return new VerticePuzzle(d);
	}

	public static VerticePuzzle create(Integer[][] datos, int x0, int y0) {
		return new VerticePuzzle(datos, x0, y0);
	}

	private VerticePuzzle(Integer[][] datos, int x0, int y0) {
		super();
		this.datos = datos;
		this.x0 = x0;
		this.y0 = y0;
	}

	private VerticePuzzle(Integer... d) {
		super();
		datos = new Integer[NUM_FILAS][NUM_FILAS];
		Set<Integer> s = new HashSet<Integer>();
		int x = 0, y = 0;
		for (int e : d) {
			if (e < 0 || e > (NUM_FILAS * NUM_FILAS - 1)) {
				throw new IllegalArgumentException();
			}
			if (e == 0) {
				this.x0 = x;
				this.y0 = y;
			}
			s.add(e);
			this.datos[x][y] = e;
			if (y == NUM_FILAS - 1) {
				x++;
				y = 0;
			} else {
				y++;
			}

		}
		if (d.length != NUM_FILAS * NUM_FILAS || s.size() != NUM_FILAS * NUM_FILAS)
			throw new IllegalArgumentException();
	}

	@Override
	public boolean isValid() {
		// TODO: EXPLICACION EN EL LABORATORIO
		Set<Integer> aux = new HashSet<Integer>();
		for (int x = 0; x < NUM_FILAS; x++) {
			for (int y = 0; y < NUM_FILAS; y++) {
				aux.add(datos[x][y]);
			}
		}
		return aux.size() == NUM_FILAS * NUM_FILAS;
	}

	@Override
	public Set<VerticePuzzle> getNeighborListOf() {
		// TODO: EXPLICACION EN EL LABORATORIO
		List<Tuple2<Integer, Integer>> ls = new ArrayList<>();
		ls.add(Tuple.create(1, 0));
		ls.add(Tuple.create(-1, 0));
		ls.add(Tuple.create(0, 1));
		ls.add(Tuple.create(0, -1));

		return ls.stream().filter(mov -> movValido(mov)).map(x -> getVecino(x.v1, x.v2)).collect(Collectors.toSet());
	}

	private Boolean movValido(Tuple2<Integer, Integer> mov) {
		return mov.v1 + x0 >= 0 && mov.v1 + x0 < NUM_FILAS && mov.v2 + y0 >= 0 && mov.v2 + y0 < NUM_FILAS;
	}

	private VerticePuzzle getVecino(Integer incx, Integer incy) {
		int f = x0 + incx;
		int c = y0 + incy;

		if (f < 0 || f >= NUM_FILAS || c < 0 || c >= NUM_FILAS) {
			throw new IllegalArgumentException();
		}

		Integer[][] dd = new Integer[NUM_FILAS][NUM_FILAS];
		for (int x = 0; x < NUM_FILAS; x++) {
			for (int y = 0; y < NUM_FILAS; y++) {
				dd[x][y] = datos[x][y];
			}
		}
		dd[f][c] = datos[x0][y0];
		dd[x0][y0] = datos[f][c];

		return create(dd, f, c);
	}

	/* Esta en Teoría */

	@Override
	public Set<SimpleEdge<VerticePuzzle>> edgesOf() {
		// TODO: EXPLICACION EN EL LABORATORIO
		return this.getNeighborListOf().stream().map(x -> SimpleEdge.of(this, x))
				.collect(Collectors.<SimpleEdge<VerticePuzzle>>toSet());
	}

	public Integer getNumDiferentes(VerticePuzzle e) {
		Integer res = 0;
		for (int x = 0; x < NUM_FILAS; x++) {
			for (int y = 0; y < NUM_FILAS; y++) {
				if(!this.datos[x][y].equals(e.datos[x][y])) {
					res++;
				}
			}
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(datos);
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
		VerticePuzzle other = (VerticePuzzle) obj;
		if (!Arrays.deepEquals(datos, other.datos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = IntStream.range(0, NUM_FILAS).boxed().map(i -> fila(i)).collect(Collectors.joining("\n", "", "\n"));
		return s;
	}

	private String fila(int i) {
		return IntStream.range(0, NUM_FILAS).boxed().map(j -> datos[i][j].toString())
				.collect(Collectors.joining("|", "|", "|"));
	}

}
