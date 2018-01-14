package com.cui.csci2110.lab1;

import java.util.Scanner;
public class demo2 { // demo class for circle class
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input first circle's x,y,radius in order: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double radius1 = input.nextDouble();
		System.out.print("Please input second circle's x,y,radius in order: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double radius2 = input.nextDouble();
		Circle c1 = new Circle(x1,y1,radius1);
		Circle c2 = new Circle(x2,y2,radius2);
		if(c1.contains(c2))
			System.out.println("First circle contains second circle.");
		else if(c2.contains(c1))
			System.out.println("Second circle contains first circle.");
		else
			System.out.println("The two circles do not contain each other.");
		if(c1.touches(c2))
			System.out.println("First circle touches second circle.");
		else if(c2.touches(c1))
			System.out.println("Second circle touches first circle.");
		else
			System.out.println("The two circles do not touch each other.");
	}
}


