package cc150;

/*
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 * 
 * Answer: compare the slopes of two lines
 */

public class Chapter07Q03 {

	// find all the prime number until max
	public boolean[] findPrimes(int max) {

		boolean[] flags = new boolean[max + 1];

		for (int i = 0; i < flags.length; i++) {
			if (i > 2)
				flags[i] = true;
			else
				flags[i] = false;
		}

		int prime = 2;

		while (prime <= Math.sqrt(max)) {

			// remove non prime numbers
			for (int i = prime * prime; i < flags.length; i = i + prime) {
				flags[i] = false;
			}

			prime = prime + 1;

			// go to next prime number
			while (prime <= flags.length && !flags[prime]) {
				prime++;
			}

		}

		return flags;

	}

	public static void main(String[] args) {

	}
}















