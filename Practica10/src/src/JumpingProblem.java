package src;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class JumpingProblem implements ProblemaPDR<List<Integer>, Integer, JumpingProblem> {

	public Integer posActual;
	public List<Integer> numeros;

	public static JumpingProblem create(List<Integer> numeros) {
		return new JumpingProblem(numeros);
	}

	private JumpingProblem(List<Integer> numeros) {
		super();
		this.posActual = 0;
		this.numeros = numeros;
	}

	public JumpingProblem clone() {
		JumpingProblem newProblem = new JumpingProblem(this.numeros);
		return newProblem;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return this.numeros.size() - 1 - this.posActual;
		// -posActual para el tamaño de los subproblemas que se generan
	}

	@Override
	public boolean esCasoBase() {
		return (this.numeros.size() - 1 == this.posActual);
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(0, 0.);
	}

	@Override
	public JumpingProblem getSubProblema(Integer a) {
		JumpingProblem newProblem = this.clone();
		newProblem.posActual = this.posActual + a;
		return newProblem;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		return Sp.create(a, s.propiedad + 1);
	}
	
	@Override
	public List<Integer> getAlternativas() {
		List<Integer> alternativas = new ArrayList<Integer>();
		if (this.numeros.get(this.posActual) != 0) {
			for (Integer i = 1; i <= this.numeros.get(this.posActual); i++) {
				if (this.posActual + i == this.numeros.size()) {
					// OJO se pone size no size()-1, porque el for empieza por 1
					break;
				}
				alternativas.add(i);
			}
		}
		return alternativas;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		s.add(0, sp.alternativa);
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
		result = prime * result + ((posActual == null) ? 0 : posActual.hashCode());
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
		JumpingProblem other = (JumpingProblem) obj;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		if (posActual == null) {
			if (other.posActual != null)
				return false;
		} else if (!posActual.equals(other.posActual))
			return false;
		return true;
	}

}
