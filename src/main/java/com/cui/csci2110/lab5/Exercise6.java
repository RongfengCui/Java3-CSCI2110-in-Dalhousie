package com.cui.csci2110.lab5;


public class Exercise6 {
	public static int squares(int n){
		if(n==1)
			return 1;
		else
			return (int)Math.pow(n, 2) + squares(n-1); //will add the value together after finishing recursion
	}
	public static void main(String [] args){
		System.out.println(Exercise6.squares(5));
	}
}
