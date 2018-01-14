package com.cui.csci2110.lab5;


public class Exercise2 {
	public static void countDown(int n){
		if(n==0){
			System.out.print("BlastOff!");
			return;
		}	
		else
			System.out.print(n + "\t");
			countDown(n-1); // using n-1
	}
	public static void main(String [] args){
		Exercise2.countDown(15);
	}
}
