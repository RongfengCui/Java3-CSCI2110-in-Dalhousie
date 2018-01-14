package com.cui.csci2110.lab5;


public class Exercise4 {
	public static void display(int n, int m){ //after finishing the recursion, then print
		if (m > 1) {
            display(n, m-1);
        }
        System.out.print(n*m + "\t");
	}
	public static void main(String [] args){
		Exercise4.display(4, 9);
	}
}
