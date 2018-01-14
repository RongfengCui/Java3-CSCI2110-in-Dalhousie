package com.cui.csci2110.lab5;


public class Exercise5 {
	public static void writeVertical(int n){ //after finishing the recursion, then print
		int rem = n % 10; // if n is 123, rem would be 3
		if (n == 0) {
            return;
        } else {
        	writeVertical(n / 10); //if n is 123, right now n/10 is 12
        }
        System.out.println(rem);
    }	
	public static void main(String [] args){
		Exercise5.writeVertical(566787);
	}
}
