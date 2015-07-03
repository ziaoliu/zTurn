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
 
 solution1
 http://www.programcreek.com/2013/02/leetcode-4sum-java/
 */

public class FourSumS1 {
	public static void main(String[] args) {
		FourSumS1 fs = new FourSumS1();
		Solution s = fs.new Solution();
		int[] num = {0, 0, 0, 0};
		System.out.println(s.fourSum(num, 0));
	}

	public class Solution {
	    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	        
	        if(num == null || num.length < 4) return result;
	        
	        Arrays.sort(num);
	        
	        for(int i = 0; i < num.length; i++){
	            
	            for(int j = i + 1; j < num.length; j++){
	                
	                int x = j + 1;
	                int y = num.length - 1;
	                
	                while(x < y){
	                    ArrayList<Integer> temp = new ArrayList<Integer>();
	                    System.out.println("i: " + i + " j: " + j + " x: " + x + " y: " + y);
	                    int sum = num[i] + num[j] + num[x] + num[y];
	                    if(sum == target){
	                        temp.add(num[i]);
	                        temp.add(num[j]);
	                        temp.add(num[x]);
	                        temp.add(num[y]);
	                        if(!set.contains(temp)){
	                            result.add(temp);
	                            set.add(temp);
	                        }
	                        x++;
	                        y--;
	                    }else if(sum > target){
	                        y--;
	                    }else{
	                        x++;
	                    }
	                    
	                }
	            }
	        }
	        
	        return result;
	    }
	}
}
