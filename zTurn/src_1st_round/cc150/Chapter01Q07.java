package cc150;

import java.util.Random;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row 
 * and column are set to 0.
 */

public class Chapter01Q07 {
	public static void main(String[] args) {

		int M = 3;
		int N = 4;

		int[][] array = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				Random r = new Random();
				int random = r.nextInt(5);
				array[i][j] = random;
			}
		}

		// print array
		print(array);

		// find 0 elements in the array and set
		set(array);

		// // print array
		// print(array);
	}

	public static void set(int[][] array) {
		int M = array.length;
		int N = array[0].length;

		boolean[] row = new boolean[M];
		boolean[] col = new boolean[N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		System.out.print("row numbers: ");
		for (int i = 0; i < M; i++) {
			if (row[i]) {
				System.out.print(i + 1 + " ");
				array[i] = new int[N];
			}
		}
		System.out.println();
		
		System.out.print("col numbers: ");
		for (int i = 0; i < N; i++) {
			if (col[i]) {
				System.out.print(i + 1 + " ");
				for (int j = 0; j < M; j++)
					array[j][i] = 0;
			}
		}
		System.out.println();
		
		print(array);

	}

	public static void print(int[][] array) {
		System.out.println("###########");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("###########");
	}
}
