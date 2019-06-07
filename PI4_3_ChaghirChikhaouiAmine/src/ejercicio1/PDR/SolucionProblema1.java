package ejercicio1.PDR;

import java.util.ArrayList;
import java.util.List;

public class SolucionProblema1 {
	
	private List<Integer> sol1;
	private List<Integer> sol2;
	
	public SolucionProblema1() {
		this.sol1 = new ArrayList<>();
		this.sol2 = new ArrayList<>();
		
	}
	public SolucionProblema1(List<Integer> a,List<Integer> b) {
		sol1 = new ArrayList<>(a);
		sol2 = new ArrayList<>(b);
	}
	public void add(Integer a, Boolean b) {
		
		if(b) {
			sol1.add(a);
		}else { 
			sol2.add(a);
		}
	}

	public static SolucionProblema1 create(List<Integer> a,List<Integer> b ) {
		return new SolucionProblema1(a,b);
	}
	
	public static SolucionProblema1 create() {
		return new SolucionProblema1();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sol1 == null) ? 0 : sol1.hashCode());
		result = prime * result + ((sol2 == null) ? 0 : sol2.hashCode());
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
		SolucionProblema1 other = (SolucionProblema1) obj;
		if (sol1 == null) {
			if (other.sol1 != null)
				return false;
		} else if (!sol1.equals(other.sol1))
			return false;
		if (sol2 == null) {
			if (other.sol2 != null)
				return false;
		} else if (!sol2.equals(other.sol2))
			return false;
		return true;
	}
	public String toString() {
		 return "Conjunto Uno = "+sol1 +"\nConjunto Dos = "+ sol2;
	}
}
