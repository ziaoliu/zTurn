package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()" 
 
 http://blog.csdn.net/fightforyourdream/article/details/14159435
 
*/

public class GenerateParentheses {
	/*
	 * Thought process:
	 * recursion = start - ( start or end) 
	 * 				       if  start - ( start or end) 
	 * 					   if  end - ( start or end) 
	 */
	public static void main(String[] args) {
		GenerateParentheses ss = new GenerateParentheses();
		Solution s = ss.new Solution();
		System.out.println(s.generateParenthesis(5));
	}
	
	public class Solution {
	    public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> result = new ArrayList<String>();
	        
	        if(n < 1) return result;
	        
	        gen("", 0, 0, n, result);
	        
	        return result;
	    }
	    
	    public void gen(String str, int left, int right, int n, ArrayList<String> result){
	        
	        if(left < right)
	            return;
	        
	        if(str.length() == n * 2){
	            result.add(str);
	            return;
	        }
	        
	        if(left == n){
	            gen(str + ")", left, right + 1, n, result);
	            return;
	        }
	        
	            gen(str + "(", left + 1, right, n, result);
	            gen(str + ")", left, right + 1, n, result);
	    }
	}
}


