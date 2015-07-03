package leetcode;

import java.util.ArrayList;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * http://www.cnblogs.com/TenosDoIt/p/3771254.html
 * http://shanjiaxin.blogspot.com/2014/02/letter-combinations-of-phone-number.html
 */

public class LetterCombinationsofPhoneNumbers {
	public static void main(String[] args) {
		LetterCombinationsofPhoneNumbers ss = new LetterCombinationsofPhoneNumbers();
		Solution s = ss.new Solution();
		System.out.println(s.letterCombinations("2"));
	}
	public class Solution {
	    public ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> result = new ArrayList<String>();
	        
	        if(digits == null) return result;
	        
	        StringBuilder sb = new StringBuilder();
	        
	        iterate(digits, 0, sb, result);
	                
	        return result;
	    }
	    
	    public void iterate(String digits, int index, StringBuilder sb, ArrayList<String> result){
	        String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        
	        if(sb.length() == digits.length()){
	            result.add(sb.toString());
	            return;
	        }
	        
	        for(int i = 0; i < map[digits.charAt(index) - '0'].length(); i++){
	            sb.append(map[digits.charAt(index)- '0'].charAt(i));
	            iterate(digits, index + 1, sb, result);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	}
}
