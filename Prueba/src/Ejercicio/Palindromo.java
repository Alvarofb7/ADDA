package Ejercicio;

public class Palindromo {

	public static void main(String[] args) {
		String palabra = "abbbababbbbaaaabbbabab";
		System.out.println(practica(palabra));
		//a|b|bbababb|bbaaaabb|babab
		//a|bab|bbabb|ababa
	}

	//Función auxiliar para averiguar si una cadena es un palíndromo
	private static boolean esPalindromo(String cadena) {
		Boolean res = true;
		Integer i = 0;
		while(i < cadena.length()/2) {
			res = res && cadena.charAt(i) == cadena.charAt(cadena.length() - i - 1);
			i++;
		}
		return res;
	}
	
	
	public static String practica(String palabra) {
		String res = "";
		Integer i = 0;
		Integer j = palabra.length();
		while(i!=j) {
			if(!esPalindromo(palabra.substring(i, j))) {
				i++;
			}else {
				res+=palabra.substring(i, j) + "|";
				j=i;
				i=0;
			}
		}
		return res;
	}

}
