package com.cui.csci2110.lab1;


public class Circle {
	private double x,y,radius; // instance variable
	public Circle(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}	
	public double getRadius() {
		return radius;
	}
	public Boolean contains(Circle c){
		if(Math.sqrt(Math.pow((x - c.getX()),2) + Math.pow((y - c.getY()),2)) <= Math.abs(radius - c.getRadius()))// whether the	square root	of (x2-x1)2 + (y2-y1)2 is less than the difference between two radius
			return true;
		return false;
	}
	public Boolean touches(Circle c){
		if((Math.sqrt(Math.pow((x - c.getX()),2) + Math.pow((y - c.getY()),2))) == Math.abs(radius + c.getRadius()) || Math.pow((x - c.getX()),2) + Math.sqrt(Math.pow((y - c.getY()),2)) == Math.abs(radius - c.getRadius()))// whether the	square root	of (x2-x1)2 + (y2-y1)2 is equal to the difference between two radius the sum of two radius
			return true;
		return false;
	}
}
