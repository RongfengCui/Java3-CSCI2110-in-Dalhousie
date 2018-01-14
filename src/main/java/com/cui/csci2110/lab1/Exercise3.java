package com.cui.csci2110.lab1;

import java.util.Scanner;
public class Exercise3 {
	public static void main(String[] args) {
		double[][] points = new double[5][2];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter " + points.length + " points: ");
		for (int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
 }

 Rectangle boundingRectangle = getRectangle(points);
 System.out.println("The bounding rectangle�s center (" + boundingRectangle.getXpos() + ", " + boundingRectangle.getYpos() + "), width " + boundingRectangle.getWidth() + ", height " + boundingRectangle.getHeight());
 }
public static Rectangle getRectangle(double[][] points){
	double minXpos = points[0][0],maxXpos = 0,minYpos = points[0][1],maxYpos = 0;
	for(int i = 0; i < points.length ; i++){ //find the smallest xpos
		if(points[i][0] < minXpos)
			minXpos = points[i][0];
	}
	for(int i = 0; i < points.length ; i++){ //find the biggest xpos
		if(points[i][0] > maxXpos)
			maxXpos = points[i][0];
	}
	for(int i = 0; i < points.length ; i++){ //find the biggest ypos
		if(points[i][1] > maxYpos)
			maxYpos = points[i][1];
	}
	for(int i = 0; i < points.length ; i++){ //find the smallest ypos
		if(points[i][1] < minYpos)
			minYpos = points[i][1];
	}
	double width = maxXpos - minXpos;
	double height = maxYpos - minYpos;
	double centerXpos = minXpos + width/2;
	double centerYpos = minYpos + height/2;
	return new Rectangle(centerXpos,centerYpos, width,height);
}
}
	
	

