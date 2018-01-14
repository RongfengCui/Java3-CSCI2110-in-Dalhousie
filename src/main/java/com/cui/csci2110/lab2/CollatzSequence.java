package com.cui.csci2110.lab2;
import java.util.Scanner;
public class CollatzSequence {
	public static void main (String [] args){
		Scanner scanner = new Scanner(System.in);
		long startTime, endTime, executionTime;
		System.out.print("Please enter the number:");
		int num = scanner.nextInt();
		startTime = System.currentTimeMillis();
		comparision(num);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;		
		System.out.println("Execution time: " + executionTime + " millisecs");
	}
	public static int length(int num){ //find the the length of sequence in specific number
		int step = 1;
		while(num != 1){
			if(num % 2 == 0)
				num = num / 2;
			else
				num = num * 3 + 1;
			step++;
		}		
		return step;	
	}
	public static void comparision(int num){ // comparing all the number with their sequence length and find the longest sequence with its corresponding number 
		int maxNum=0, maxStep=0;
		for(int i = 1; i <= num; i++){
			int num1 = length(i);
			if(num1 > maxStep){
				maxNum = i;
				maxStep = num1;
			}				
		}
		System.out.println("the longest sequence is " + maxNum  + " and the length of the sequence is " + maxStep);
	}
}