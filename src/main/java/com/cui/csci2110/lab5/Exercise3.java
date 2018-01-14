package com.cui.csci2110.lab5;


public class Exercise3 {
	public static void countDown(int n){
		if(n==0 || n==-1){ //0 for n is even, and -1 for n is odd 
			System.out.print("BlastOff!");
			return;
		}
		else{	
			System.out.print(n + "\t");
			countDown(n - 2); //using n-2
		}
	}
	public static void main(String [] args){
		Exercise3.countDown(16);
	}
}
