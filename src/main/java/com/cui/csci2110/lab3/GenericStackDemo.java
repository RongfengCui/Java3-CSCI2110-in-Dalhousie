package com.cui.csci2110.lab3;


public class GenericStackDemo { //demo class
	public static void main(String[] args){
	GenericStack<String> stack1 = new GenericStack<String>();
	stack1.push("London");
	stack1.push("Paris");
	stack1.push("Halifax");
	stack1.pop();
	System.out.println(stack1.peek());
	GenericStack<Integer> stack2 = new GenericStack<Integer>();
	stack2.push(1);
	stack2.push(2);
	stack2.push(3);
	stack2.pop();
	stack2.pop();
	System.out.println(stack2.peek());
	}
}
