package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
	Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
	Find all unique quadruplets in the array which gives the sum of target.

	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
	The solution set must not contain duplicate quadruplets.

	For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

	A solution set is:
	(-1,  0, 0, 1)
	(-2, -1, 1, 2)
	(-2,  0, 0, 2)

 */

public class FourSumQuestion {

	public static int[] S = {1, 0, -1, 0, -2, 2};
	
	public static void main(String[] args) {
		System.out.println(findUtil(0).size());
	}
	
	public static HashSet<ArrayList<Integer>> findUtil(int target){
		
		Arrays.sort(S);
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		
		int i, j, x, y;
		
		for(i = 0; i < S.length - 3; i++){
			for(j = i + 1; j < S.length - 2; j++){
				x = j + 1;
				y = S.length - 1;
				while(x < y){
					if(S[i] + S[j] + S[x] + S[y] == target){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(S[i]);
						temp.add(S[j]);
						temp.add(S[x]);
						temp.add(S[y]);
						
						result.add(temp);
						
						System.out.println("found entry: [ " + S[i] + " , " + S[j] + " , " + S[x] + " , " + S[y] + " ]" );
						x++;
						y--;
					}else if(S[i] + S[j] + S[x] + S[y] > target){
						y--;
					}else
						x++;
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}
	
}
