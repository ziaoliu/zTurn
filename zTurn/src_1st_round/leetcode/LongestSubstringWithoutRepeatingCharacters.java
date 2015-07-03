package leetcode;

import java.util.ArrayList;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		Solution a = solution.new Solution();
		int x = a.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
		System.out.println(x);
	}
	
	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			if(null == s || s.equals("")) return 0;
	        
	        if(s.length()== 1) return 1;
	        
	        char[] string = s.toCharArray();
	        boolean[] tag = new boolean[1000];
	        
	        int length = 0;
			int index = 0; // found repeat char
			int max = 0;
			
			for(int i = 0; i <string.length; i++){
			    // not consecutive
			    if(tag[string[i]]){
			    	if(length > max) max = length;
			        length = 0;
			        for(int k = index; k < i; k++){
			        	if(string[k] == string[i]){
			        		index = k;
			        		break;
			        	}
			        	tag[string[k]] = false;
			        }
			        i = index;
			    }else{
			        tag[string[i]] = true;
			        length++;
			    } 
			}
			if(length > max) max = length;	
			return max;
		}
	}

}
