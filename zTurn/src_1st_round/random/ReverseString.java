package random;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseInPlace("123456"));
	}

	public static String reverseInPlace(String str) {

		if (str == null)
			return null;

		char[] array = str.toCharArray();

		int head = 0;
		int end = array.length - 1;

		while(head < end){
			char temp = array[head];
			array[head] = array[end];
			array[end] = temp;
			
			head++;
			end--;
		}
		
		str = new String(array);
		
		return str;
	}
}
