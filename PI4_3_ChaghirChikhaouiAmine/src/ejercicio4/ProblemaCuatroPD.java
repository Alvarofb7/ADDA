package ejercicio4;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class ProblemaCuatroPD implements ProblemaPD<String, Integer, ProblemaCuatroPD>{
	
	
	
	private String cadena;
	private Integer index1;
	private Integer index2;
	
	public ProblemaCuatroPD(String cadena,Integer index1,Integer index2) {
		super();
		this.cadena = cadena;
		this.index1 = index1;
		this.index2 = index2;
	}
	
	public static ProblemaCuatroPD create(String cadena,Integer index,Integer index2) {
		return new ProblemaCuatroPD(cadena,index,index2);
	}
	//Funcion para saber si una cadena es Palindromo o no
	public static boolean esPalindromo(String cadena) {
		Boolean res = true; 
		Integer acum = 0;
		while(acum<= cadena.length()-1) {
			if(cadena.charAt(0+acum) == cadena.charAt(cadena.length()-1-acum)) {
				res = true;
				acum++;
			}else {
				res = false;
				break;
			}
		
		}
		return res;
	}
	
	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return Tipo.Min;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return index2-index1;
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		return esPalindromo(cadena.substring(index1,index2));
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		return Sp.create(index2, 1.0);
	}

	@Override
	public ProblemaCuatroPD getSubProblema(Integer a, int np) {
		ProblemaCuatroPD res = null;
		if(np==0) {
			res = new ProblemaCuatroPD(cadena, index1, a);
		}else {
			res = new ProblemaCuatroPD(cadena, a, index2);
		}
		return res;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		// TODO Auto-generated method stub
		return Sp.create(a, (double)ls.get(0).propiedad + ls.get(1).propiedad);
	}

	@Override
	public List<Integer> getAlternativas() {
		
		return IntStream.range(index1+1, index2).boxed().collect(Collectors.toList());
	}

	@Override
	public int getNumeroSubProblemas(Integer a) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return cadena.substring(index1,index2);
	}

	@Override
	public String getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<String> ls) {
		// TODO Auto-generated method stub
		return ls.get(0) + "|"+ls.get(1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadena == null) ? 0 : cadena.hashCode());
		result = prime * result + ((index1 == null) ? 0 : index1.hashCode());
		result = prime * result + ((index2 == null) ? 0 : index2.hashCode());
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
		ProblemaCuatroPD other = (ProblemaCuatroPD) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		if (index1 == null) {
			if (other.index1 != null)
				return false;
		} else if (!index1.equals(other.index1))
			return false;
		if (index2 == null) {
			if (other.index2 != null)
				return false;
		} else if (!index2.equals(other.index2))
			return false;
		return true;
	}
	
}