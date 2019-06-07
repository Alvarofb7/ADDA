package Ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practica {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		System.out.println(numeros);

		List<Integer> numeros2 = Arrays.asList(1, 3, 1, 1, 2, 5, 2, 2, 8, 8, 10, 8, 11);
		System.out.println(getAlternativas(numeros, 24));
		System.out.println(getAlternativas(numeros2, 34));

//		String palabra = "abbaaba";
//		System.out.println(palabra);
//		System.out.println(palindromo(palabra));
//		System.out.println(palindromoWhile(palabra));

	}
	
	public static List<Integer> getAlternativas(List<Integer> numeros, Integer n) {
		List<Integer> alternativas = new ArrayList<>();
		Integer suma = 0;
		for (int i = 0; i < numeros.size(); i++) {
			if (numeros.get(i) % 2 == 0) {
				suma += numeros.get(i);
				alternativas.add(numeros.get(i));
			}
		}
		System.out.println("Lista de pares:" + alternativas);
		if (suma == n) {
			return alternativas;
		} else if (suma < n) {
			System.out.println("No hay suficientes elementos pares para llegar al nº dado");
		} else {
			Integer diferencia = suma - n;
			if (alternativas.contains(diferencia)) {
				alternativas.remove(diferencia);
				return alternativas;
			} else {
				List<Integer> numMenores = new ArrayList<>();
				for (int i = 0; i < alternativas.size() - 1; i++) {
					for (int j = i + 1; j < alternativas.size(); j++) {
						if ((alternativas.get(i) + alternativas.get(j)) == diferencia) {
							alternativas.remove(alternativas.get(i));
							alternativas.remove(alternativas.get(j - 1));
							return alternativas;
						} else if ((alternativas.get(i) + alternativas.get(j)) != diferencia) {
							if (alternativas.get(i) < diferencia) {
								numMenores.add(alternativas.get(i));
							} else if (alternativas.get(j) < diferencia) {
								numMenores.add(alternativas.get(j));
							}
						}
					}
				}

			}
		}
		return alternativas;
	}

	public static List<String> palindromo(String palabra) {
		List<Character> letras = new ArrayList<>();
		for (int i = 0; i < palabra.length(); i++) {
			letras.add(palabra.charAt(i));
		}
		List<String> res = new ArrayList<>();
		return palindromo(letras, 0, letras.size() - 1, res);
	}

	private static List<String> palindromo(List<Character> letras, int i, int j, List<String> res) {
		if (letras.size() == 0) {
			return res;
		} else {
			if (letras.get(i) == letras.get(j)) {
				if (i == j || i == j - 1) {
					String sol = "";
					for (int a = 0; a < j; a++) {
						sol += letras.get(a).toString() + letras.get(a + 1).toString();
					}
					res.add(sol + " | ");
					for (int b = j; b == 0; b--) {
						letras.remove(letras.get(b));
					}
					palindromo(letras, 0, letras.size() - 1, res);
				} else {
					palindromo(letras, i++, j--, res);
				}
			} else {
				palindromo(letras, i, j--, res);
			}
		}
		return res;
	}

//	public static List<Character> palindromoWhile(String palabra){
//		List<Character> res = new ArrayList<>();
//		List<Character> letras = new ArrayList<>();
//		for (int i = 0; i < palabra.length(); i++) {
//			letras.add(palabra.charAt(i));
//		}
//		Integer i = 0;
//		Integer j = letras.size()-1;
//		while(i<letras.size()){
//			if(palabra.charAt(i) == palabra.charAt(j)) {
//				if(i==j || i==j-1) {
//					for(int a = 0; a<=j;a++) {
//						res.add(letras.get(a));
//					}
//					res.add('|');
//					for(int b = 0;b <= j; b++) {
//						letras.remove(b);
//					}
//					if(letras.size()==0) {
//						break;
//					}
//					i=0;
//					j=letras.size()-1;
//				}
//				i++;
//				j--;
//			}else {
//				j--;
//			}
//		}
//		return res;
//	} 
}
