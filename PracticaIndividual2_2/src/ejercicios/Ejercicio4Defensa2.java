package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4Defensa2 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("f");
		l.add("g");
		l.add("h"); 
		l.add("i");
		l.add("j");
		l.add("k");
		l.add("l");
		l.add("m");
		l.add("n");
		l.add("o");
		l.add("p");
		l.add("q");
		l.add("r");
		l.add("s");
		l.add("t");
		l.add("u");
		l.add("v");
		l.add("w");
		l.add("x");
		l.add("y");
		l.add("z");
		
		System.out.println(l);
		System.out.println("alvaro: " + busquedaIndice2(l, "alvaro"));
		for(int i=0; i<l.size(); i++) {
			System.out.println("El índice de " + l.get(i) + " es " + busquedaIndice2(l, l.get(i)));
		}
	
	}

	public static Integer busquedaIndice(List<String> l, String p) {
		return busquedaIndice(l, p, 0, l.size() / 3, (2 * l.size()) / 3, l.size() - 1);
	}
	
	private static Integer busquedaIndice(List<String> l, String p, int i, int j, int k, int z) {
		Integer res = -1;
		if (z - i <= 5 && !l.contains(p)) {
			return res;
		} else {
			if (l.get(i) == p) {
				return i;
			} else if (l.get(j) == p) {
				return j;
			} else if (l.get(k) == p) {
				return k;
			} else if (l.get(z) == p) {
				return z;
			} else if (l.get(j).compareTo(p) > 0) {
				return busquedaIndice(l, p, i, ((j - i) / 3) + i, ((2 * (j - i)) / 3) + i, j);
			} else if (l.get(j).compareTo(p) < 0 && l.get(k).compareTo(p) > 0) {
				return busquedaIndice(l, p, j + 1, ((k - (j + 1)) / 3) + (j + 1), (2 * (k - (j + 1)) / 3) + (j + 1), k);
			} else if (l.get(k).compareTo(p) < 0) {
				return busquedaIndice(l, p, k + 1, ((z - (k + 1)) / 3) + (k + 1), (2 * (z - (1 + k)) / 3) + (k + 1), z);
			}
		}
		return res;
	}
	
	public static List<Integer> busquedaIndice2(List<String> l, String p) {
		return busquedaIndice2(l, p, 0, l.size() - 1,new ArrayList<Integer>());
	}
	
	private static List<Integer> busquedaIndice2(List<String> l, String p, int i, int z, List<Integer> res) {
		Integer j = (z-i)/3;
		Integer k =2*(z-i)/3;
		if (z - i <= 5 && !l.contains(p)) {
			return res;
		} else {
			if (l.get(i) == p) {
				for(int a = 0; a<=i;a++) {
					res.add(a);
				}
				return res;
			} else if (l.get(j) == p) {
				for(int a = 0; a<=j;a++) {
					res.add(a);
				}
				return res;
			} else if (l.get(k) == p) {
				for(int a = 0; a<=k;a++) {
					res.add(a);
				}
				return res;
			} else if (l.get(z) == p) {
				for(int a = 0; a<=z;a++) {
					res.add(a);
				}
				return res;
			} else if (l.get(j).compareTo(p) > 0) {
				return busquedaIndice2(l, p, i, j-1,res);
			} else if (l.get(j).compareTo(p) < 0 && l.get(k).compareTo(p) > 0) {
				return busquedaIndice2(l, p,j+1,k-1,res);
			} else if (l.get(k).compareTo(p) < 0) {
				return busquedaIndice2(l, p, k + 1, z-1,res);
			}
		}
		return res;
	
	
	}
	
	
//	public static List<String> busqueda(List<String> l,String p, Integer i){
//		List<String> res = new ArrayList<String>();
//		while(l.get(i) != p) {
//			res.add(l.get(i));
//			i++;
//		}
//		return res;
//}
//	
//	public static List<String> busqueda2(List<String> l, String p){
//		return busqueda2(l,p,0, new ArrayList<String>());
//	}
//	
//	private static List<String> busqueda2(List<String> l,String p, Integer i, List<String> res){
//		if(l.get(i).compareTo(p)==0) {
//			return res;
//		}else if(l.get(i)!=p) {
//				res.add(l.get(i));
//				busqueda2(l, p, i+1, res);
//		}
//		return res;
//}

}
