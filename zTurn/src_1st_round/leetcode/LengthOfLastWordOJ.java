package leetcode;

/* Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/21858067
 */
public class LengthOfLastWordOJ {
	public class Solution {
	    public int lengthOfLastWord(String s) {
	        if(null == s)
	        	return 0;
	        int result = 0;
	        char[] array = s.trim().toCharArray();
	        for(int i = s.trim().length() - 1; i >= 0; i--){
	        	if(array[i] != ' '){
	        		result++;
	        	}else{
	        		break;
	        	}
	        }
	        return result;
	    }//end of method
	}
}
