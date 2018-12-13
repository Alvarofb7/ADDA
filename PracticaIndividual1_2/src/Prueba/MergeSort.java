package Prueba;

import java.util.Arrays;

public class MergeSort {

	private static int[] izqSubArray(int[] Array) {
		int[] izqMitad = Arrays.copyOfRange(Array, 0, Array.length / 2);
		return izqMitad;
	}

	private static int[] DerSubArray(int[] Array) {
		int[] derMitad = Arrays.copyOfRange(Array, Array.length / 2, Array.length);
		return derMitad;
	}

	private static int[] Sort(int[] A) {
		if (A.length > 1) {
			return Merge(Sort(izqSubArray(A)), Sort(DerSubArray(A)));
		} else {
			return A;
		}
	}

	private static int[] Merge(int[] B, int[] C) {
		int[] D = new int[B.length + C.length];
		int i, j, k;
		i = j = k = 0;
		while (k < D.length) {
			if (i == B.length) {
				//Copy the remainder of C into D
				while (j < C.length) {
					D[k++] = C[j++];
				}
			}
			if (j == C.length) {
				//Copy the remainder of B into D
				while (i < B.length) {
					D[k++] = B[i++];
				}
			}
			if (i < B.length && j < C.length) {
				if (B[i] > C[j]) {
					D[k++] = B[i++];
				} else {
					D[k++] = C[j++];
				}
			}
		}
		return D;
	}
	
	public static void main(String[] args) {
		int[] array = {1,3,5,2,4};
		int[] sorted = MergeSort.Sort(array);
		for(int i = 0; i<sorted.length; ++i) {
			System.out.println(sorted[i] + "");
		}
	}

}
