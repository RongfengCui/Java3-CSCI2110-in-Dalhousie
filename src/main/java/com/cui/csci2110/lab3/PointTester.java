package com.cui.csci2110.lab3;


public class PointTester {
	public static void main(String[] args) {
	Point<Integer> point1 = new Point<Integer>(20,200);
	Point<Double> point2 = new Point<Double>(14.0,15.0);
	Point<String> point3 = new Point<String>("people","car");
	System.out.println(point1);
	System.out.println(point2);
	System.out.println(point3);
	}
}
