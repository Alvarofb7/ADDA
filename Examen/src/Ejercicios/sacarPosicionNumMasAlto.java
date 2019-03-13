package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class sacarPosicionNumMasAlto {

	public static void main(String[] args) {
		List<Integer> dt = new ArrayList<Integer>();
		dt.add(0);
		dt.add(3);
		dt.add(4);
		dt.add(6);
		dt.add(9);
		dt.add(14);
		dt.add(8);
		dt.add(6);
		dt.add(2);
		dt.add(1);
		System.out.println(posMaxBitonica(dt));
		
	}

	public static Integer posMaxBitonica(List<Integer> dt) {
		return pMaxBit(dt , 0, dt.size());
	}

	private static Integer pMaxBit(List<Integer> dt, int i, int j) {
		Integer res = 0;
		if(j==i+1){
			res = i;
		}else {
			Integer m = (i+j)/2;
			if(dt.get(m-1).compareTo(dt.get(m))>0) {
				res = pMaxBit(dt, i, m);
			}else {
				res = pMaxBit(dt, m, j);
				}
		}
		return res;
	}
	
	
}
