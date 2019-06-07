package ejercicio1.PDR;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Problema1PDR implements ProblemaPDR<SolucionProblema1, Boolean, Problema1PDR> {
	
	public Problema1PDR(int index, List<Integer> conj1, List<Integer>conj2) {
		// TODO Auto-generated constructor stub
		this.index = index;
		this.conj1 = new ArrayList<>(conj1);
		this.conj2 = new ArrayList<>(conj2);
	}

	public static Problema1PDR createInitial() {
		return new Problema1PDR(0,new ArrayList<>(),new ArrayList<>());
	}
	
	private Integer index;
	private List<Integer> conj1;
	private List<Integer> conj2;
	
	
	@Override
	public Tipo getTipo() {
		
		return Tipo.Min;
	}

	@Override
	public int size() {
		
		return DatosProblema1.numeros.size() - index;
	}

	@Override
	public boolean esCasoBase() {
		
		return this.index == DatosProblema1.numeros.size();
	}
	public static Integer suma(List<Integer> ls ) {
		return ls.stream().mapToInt(i->i).sum();
	}
	@Override
	public Sp<Boolean> getSolucionParcialCasoBase() {
		Sp<Boolean> res = null;
		if(suma(conj1) == suma(conj2)) {
			res = Sp.create(null, 0.0);/*Si no se cumple esto devuelve null y por ahi no continua*/
		}
		return res;
	}
	private static Integer capacidad = suma(DatosProblema1.numeros)/2;
	@Override
	public Problema1PDR getSubProblema(Boolean a) {
		Problema1PDR res= null;
		Integer num = DatosProblema1.numeros.get(index);
		List<Integer> nuevoConj1 = new ArrayList<>(conj1);
		List<Integer> nuevoConj2 = new ArrayList<>(conj2);
		
		if(a) {
			nuevoConj1.add(num);
		}else {
			nuevoConj2.add(num);
		}
		
		res = new Problema1PDR(index+1, nuevoConj1, nuevoConj2);
		
		return res;
	}

	@Override
	public Sp<Boolean> getSolucionParcialPorAlternativa(Boolean a, Sp<Boolean> s) {
		// TODO Auto-generated method stub
		Integer n1 = conj1.size();
		Integer n2 = conj2.size();
		Sp<Boolean> res = Sp.create(a, s.propiedad);
		if(a && Math.min(n1, n2)==n1) {
			res = Sp.create(a, s.propiedad+1);
		}else if(!a && Math.min(n1, n2)==n2) {
			res = Sp.create(a, s.propiedad+1);
		}
		return res;
	}

	@Override
	public List<Boolean> getAlternativas() {
		List<Boolean> res = new ArrayList<Boolean>();
		res.add(true);
		res.add(false);
		return res;
	}

	@Override
	public SolucionProblema1 getSolucionReconstruidaCasoBase(Sp<Boolean> sp) {
		// TODO Auto-generated method stub
		return	SolucionProblema1.create();
	}

	@Override
	public SolucionProblema1 getSolucionReconstruidaCasoRecursivo(Sp<Boolean> sp, SolucionProblema1 s) {
		s.add(DatosProblema1.numeros.get(index), sp.alternativa);
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conj1 == null) ? 0 : conj1.hashCode());
		result = prime * result + ((conj2 == null) ? 0 : conj2.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
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
		Problema1PDR other = (Problema1PDR) obj;
		if (conj1 == null) {
			if (other.conj1 != null)
				return false;
		} else if (!conj1.equals(other.conj1))
			return false;
		if (conj2 == null) {
			if (other.conj2 != null)
				return false;
		} else if (!conj2.equals(other.conj2))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}
	
	public String toString() {
		return "Conjunto Uno = " +conj1+"\nConjunto Dos = "+conj2;
	}
}
