package Ejercicios;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(sfactorial(1024));
		System.out.println(sfactorialFinal(1024));
	}
	//Recursivo no final
	public static Integer sfactorial(Integer n) {
		Integer res = 0;
		if (n < 10) {
			res = factorial(n);
		} else {
			res = sfactorial(n/10) + factorial(n%10); 
		}
		return res;
	}
	
	//Recursivo final
	public static Integer sfactorialFinal(Integer n) {
		return sfactorialFinal(n, 0);
	}
	
	private static Integer sfactorialFinal(Integer n, Integer acu) {
		Integer res = 0;
		if(n<10) {
			res = acu + factorial(n); 
		}else {
			res = sfactorialFinal(n/10, acu + factorial(n%10));
		}
		return res;
	}
	//Metodo auxiliar factorial
	private static Integer factorial(Integer n) {
		Integer res = 0;
		if (n == 0 || n == 1) {
			res = 1;
		} else {
			res = n*factorial(n-1);
		}
		return res;
	}
	

	
	
	
	
}
