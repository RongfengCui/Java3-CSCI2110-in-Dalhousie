package com.cui.csci2110.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1Q3 extends E1Q2{
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.print("Please enter a number: ");
		int num = input.nextInt();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		list = getAllBinaryNumbers(list,num);
		list = pickUpBinaryNumbers(list,num);
		list = printRoute(list);
		System.out.println(getAllRoute(list,num));
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime; // use the endTime to minus the startTime to get the execution time
		System.out.println("Execution time is " + executionTime + " millisecs");
	}
}
