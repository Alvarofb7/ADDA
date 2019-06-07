package Ejercicio4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class Palindromo implements ProblemaPD<String, Integer, Palindromo> {

	private String cadena;
	private int i, j;

	public static Palindromo create(String cadena, int i, int j) {
		return new Palindromo(cadena, i, j);
	}

	public Palindromo(String cadena, int i, int j) {
		super();
		this.cadena = cadena;
		this.i = i;
		this.j = j;
	}

	public Palindromo clone() {
		Palindromo nuevoProblema = new Palindromo(this.cadena, this.i, this.i);
		return nuevoProblema;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return j - i;
	}

	@Override
	public boolean esCasoBase() {
		return esPalindromo(cadena.substring(i, j));
	}

	//Función auxiliar para averiguar si una cadena es un palíndromo
	private boolean esPalindromo(String cadena) {
		Boolean res = true;
		Integer i = 0;
		while(i < cadena.length()/2) {
			res = res && cadena.charAt(i) == cadena.charAt(cadena.length() - i - 1);
			i++;
		}
		return res;
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(j, 1.0);
	}

	@Override
	public Palindromo getSubProblema(Integer a, int np) {
		Palindromo res = null;
		if(np == 0) {
			res = new Palindromo(cadena, i, a);
		}else {
			res = new Palindromo(cadena, a, j);
		}
		
		return res;
	}
	
	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		return Sp.create(a, (double) ls.get(0).propiedad + ls.get(1).propiedad);
	}
	
	@Override
	public List<Integer> getAlternativas() {
		return IntStream.range(i+1, j).boxed().collect(Collectors.toList());
	}

	@Override
	public int getNumeroSubProblemas(Integer a) {
		return 2;
	}

	@Override
	public String getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return cadena.substring(i, j);
	}

	@Override
	public String getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<String> ls) {
		return ls.get(0) + "-" + ls.get(1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadena == null) ? 0 : cadena.hashCode());
		result = prime * result + i;
		result = prime * result + j;
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
		Palindromo other = (Palindromo) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}




	
}
