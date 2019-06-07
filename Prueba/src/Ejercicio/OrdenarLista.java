package Ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenarLista {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		
		System.out.println(ordenar(numeros));
	}

	public static List<Integer> ordenar(List<Integer> numeros){
		List<Integer> res = new ArrayList<>();
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		for(int i = 0; i < numeros.size(); i++) {
			if(numeros.get(i)%2==0) {
				pares.add(numeros.get(i));
			}else {
				impares.add(numeros.get(i));
			}
		}
		Collections.sort(pares);
		res.addAll(pares);
		res.addAll(impares);
			
		return res;
	}
	
}
