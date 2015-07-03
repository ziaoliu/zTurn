package cc150;

import java.util.Stack;

/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class Chapter03Q05 {
	public static void main(String[] args) {
		
	}

}

class MyQueue{
	private java.util.Stack<Integer> in = new Stack<Integer>();
	private java.util.Stack<Integer> out = new Stack<Integer>();
	
	public void myEnQ(int data){
		in.add(data);
	}
	
	public int myDeQ(){
		shiftStacks();
		return out.pop();
	}
	
	public int peek(){
		shiftStacks();
		return out.peek();
	}
	
	private void shiftStacks(){
		if(out.isEmpty()){
			while(!in.isEmpty()){
				out.push(in.pop());
			}
		}
	}
}
