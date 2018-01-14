package com.cui.csci2110.lab2;

import java.util.Scanner;
public class Exponential {
	public static void main(String[] args) {
		long startTime, endTime, executionTime;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the number:");
		int num = scanner.nextInt();
		test(num);
	}
	public static void test(int num){
		for(int i = 0; i < (int)Math.pow(2,num); i++){ //using for loop to get the binary number
			String s = Integer.toBinaryString(i);
			System.out.print(s);
		}
	}
}
