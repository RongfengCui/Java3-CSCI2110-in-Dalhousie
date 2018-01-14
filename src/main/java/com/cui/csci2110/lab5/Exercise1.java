package com.cui.csci2110.lab5;

import java.util.Scanner;
public class Exercise1 {
	public static int fib(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			return fib(n-1) + fib(n-2); //just like the instruction in lab
	}
	public static int factorial(int n){
		if(n==0)
			return 1;
		else
			return n * factorial(n-1);
	}
	public static int power(int x, int n){
		if(n==0)
			return 1;
		else
			return power(x,n-1) * x;
	}
	public static void main(String [] args){
		Scanner keyboard  = new Scanner(System.in);
		for(int i = 1; i <= 20; i++){
			System.out.print(fib(i) +", ");
		}
		System.out.println("\n");
		for(int i = 1; i <= 10; i++){
			System.out.print(factorial(i) +", ");
		}
		System.out.println("\n");
		System.out.print("Please enter two numbers: ");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		System.out.println(power(num1,num2));
	}
}
