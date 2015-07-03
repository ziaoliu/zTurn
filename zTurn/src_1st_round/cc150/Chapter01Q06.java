package cc150;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class Chapter01Q06 {
	public static void main(String[] args) {

		int M = 6;

		int[][] array = new int[M][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = i;
			}
		}

		// print array
		print(array);

		// rotate array
		rotate(array);
		
		System.out.println("after transform");
		print(array);
	}

	public static void rotate(int[][] array) {
		int[] temp = new int[array.length];

		for (int outer = 0; outer < array.length / 2; outer++) {
			for (int inner = outer; inner < array.length - outer - 1; inner++) {
				// back up top row
				temp[inner] = array[outer][inner];

				// left to top
				array[outer][inner] = array[array.length - 1 - inner][outer];

				// bottom to left
				array[array.length - 1 - inner][outer] = array[array.length - 1
						- outer][array.length - 1 - inner];

				// right to bottom
				array[array.length - 1 - outer][array.length - 1 - inner] = array[array.length
						- 1 - inner][array.length - 1 - outer];

				// top(temp) to right
				array[array.length - 1 - inner][array.length - 1 - outer] = temp[inner];
			}
		}

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
