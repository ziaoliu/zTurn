package random;

import java.util.ArrayList;
import java.util.Collections;

/*
 * digits are stored in ArrayList, goal is to sum up long int
 */

public class BigIntAddition {

	public ArrayList<Integer> digits = new ArrayList<Integer>();

	void add(BigIntAddition longInt) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		int aSize = this.digits.size();
		int bSize = longInt.digits.size();
		
		int counter = 0;
		int carryOver = 0;
		
		// iterate thru two lists from the last position
		while(counter < aSize || counter < bSize){
			int a = 0;
			int b = 0;
			if(counter < aSize){
				a = this.digits.get(aSize - 1 - counter);
//				System.out.println("a: " + a);
			}
			if(counter < bSize){
				b = longInt.digits.get(bSize - 1 - counter);
//				System.out.println("b: " + b);
			}
			
			int sum = a + b + carryOver;
			carryOver = 0;
			
			if(sum < 10){
				results.add(sum);
			}else{
				carryOver = 1;
				sum = sum - 10;
				results.add(sum);
			}
			counter++;
		}
		
		Collections.reverse(results);
		
		for(int i: results){
			System.out.print(i + " ");
		}
		
	}
}

class Test {
	public static void main(String[] args) {
		// big1: 1984
		BigIntAddition big1 = new BigIntAddition();
		big1.digits.add(1);
		big1.digits.add(9);
		big1.digits.add(8);
		big1.digits.add(4);
		big1.digits.add(9);
		big1.digits.add(8);

		for(int i : big1.digits){
			System.out.print(i + " ");
		}
		System.out.println();
		
		// big2: 226
		BigIntAddition big2 = new BigIntAddition();
		big2.digits.add(2);
		big2.digits.add(9);
		big2.digits.add(8);
		big2.digits.add(2);
		big2.digits.add(6);

		for(int i : big2.digits){
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("=");
		big1.add(big2);
	}
}