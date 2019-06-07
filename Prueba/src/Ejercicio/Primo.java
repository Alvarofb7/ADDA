package Ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Primo {

	public static void main(String[] args) {
		for (int i = 1; i <= 30; i++) {
			//System.out.println("¿El número " + i + " es primo? " + esPrimo(i));
		}
		//System.out.println("Fibonacci: " + fib(7));
		
	}

	public static Boolean esPrimo(Integer n) {
		Boolean res = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i != 0) {
				res = true;
			} else {
				res = false;
				break;
			}
		}
		return res;
	}

	public static int fib(int n) {
		int[] fibTab = new int[n+1];
		fibTab[0] = fibTab[1] = 1;
		for (int i = 2; i <= n; i++)
			fibTab[i] = fibTab[i - 1] + fibTab[i - 2];
		return fibTab[n];
	}
	
	
}
