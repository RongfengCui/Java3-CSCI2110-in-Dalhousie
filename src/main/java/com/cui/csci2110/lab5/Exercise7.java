package com.cui.csci2110.lab5;

import java.util.Scanner;
public class Exercise7 {
	public static void moveDiscs(int n, int from, int to, int temp){
		if(n>0){
			moveDiscs(n-1, from, temp, to); // moving to temp
			moveDiscs(n-1,temp,to,from);// moving the temp to the final place
		}
	}
	public static void main(String [] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number of discs: ");
		int numDiscs = keyboard.nextInt();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		moveDiscs(numDiscs,1,3,2);	
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("The execution time is " + executionTime + " milliseconds.");
	}
}
