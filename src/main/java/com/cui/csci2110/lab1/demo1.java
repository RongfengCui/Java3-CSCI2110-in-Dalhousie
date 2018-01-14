package com.cui.csci2110.lab1;

import java.util.Scanner;
public class demo1 { // demo class for rectangle class
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input first rectangle's xpos,ypos,width,height in order: ");
		double xpos1 = input.nextDouble();
		double ypos1 = input.nextDouble();
		double width1 = input.nextDouble();
		double height1 = input.nextDouble();
		System.out.print("Please input second rectangle's xpos,ypos,width,height in order: ");
		double xpos2 = input.nextDouble();
		double ypos2 = input.nextDouble();
		double width2 = input.nextDouble();
		double height2 = input.nextDouble();
		Rectangle r1 = new Rectangle(xpos1,ypos1,width1,height1);
		Rectangle r2 = new Rectangle(xpos2,ypos2,width2,height2);
		if(r1.contains(r2))
			System.out.println("First rectangle contains second rectangle.");
		else if(r2.contains(r1))
			System.out.println("Second rectangle contains first rectangle.");
		else
			System.out.println("The two rectangles do not contain each other.");
		if(r1.touches(r2))
			System.out.println("First rectangle touches second rectangle.");
		else if(r2.touches(r1))
			System.out.println("Second rectangle touches first rectangle.");
		else
			System.out.println("The two rectangles do not touch each other.");
	}
}
