package random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* Maximum path sum
 * 
 * https://projecteuler.net/problem=18
 * https://projecteuler.net/problem=67
 */
public class MaximumPathSumProjectEuler {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File file = new File("src_1st_round/random/p067_triangle.txt");
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Integer[][] inputArray = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				ArrayList<Integer> temp = new ArrayList<>();
				String[] array = line.split(" ");
				for (int i = 0; i < array.length; i++) {
					int num = Integer.parseInt(array[i]);
					temp.add(num);
				}
				list.add(temp);
			}
			inputArray = new Integer[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				ArrayList<Integer> row = list.get(i);
				inputArray[i] = row.toArray(new Integer[row.size()]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int result = triangle(inputArray);
		long end = System.currentTimeMillis();
		System.out.println(result + " in " + (end - start) + "miliseconds");

	}

	public static int triangle(Integer[][] array) {
		int index = array.length - 1;
		for (int i = index - 1; i >= 0; i--) {
			Integer[] n = array[i];
			Integer[] n1 = array[i + 1];
			for (int j = 0; j < n.length; j++) {
				n[j] = Math.max(n1[j], n1[j + 1]) + n[j];
			}
			array[i] = n;
		}
		return array[0][0];
	}
}
