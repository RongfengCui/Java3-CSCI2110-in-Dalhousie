package com.cui.csci2110.lab3;

import java.util.ArrayList;
public class GenericStack<T> {
	private ArrayList<T> stack;
	public GenericStack(){
		stack = new ArrayList<T>();
	}
	
	public ArrayList<T> getStack() {
		return stack;
	}

	public void setStack(ArrayList<T> stack) {
		this.stack = stack;
	}

	public boolean isEmpty(){
		return (stack.size() == 0);
	}
	public int getSize(){
		return stack.size();
	}
	public void push(T element){ //push just using add method in arraylist
		stack.add(element);
	}
	public T pop(){ //remove the last index variable in the arraylist
		T result = null;
		if(stack.size() == 0)
			System.out.println("Cannot pop");
		else
			result = stack.remove(stack.size() - 1);
		return result;
	}
	public T peek(){ //get the last index variable in the arraylist
		T result = null;
		if(stack.size() == 0)
			System.out.println("Cannot peek");
		else
			result = stack.get(stack.size() - 1);
		return result;
	}
}
