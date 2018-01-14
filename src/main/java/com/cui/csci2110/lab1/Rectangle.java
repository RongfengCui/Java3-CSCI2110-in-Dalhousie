package com.cui.csci2110.lab1;


public class Rectangle {
	private double xpos, ypos, width, height; //instance variable

	public Rectangle(double xpos, double ypos, double width, double height) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
	}

	public double getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public Boolean contains(Rectangle r){
		if(r.getXpos() >= this.xpos && r.getYpos() >= this.ypos)
			if(( r.getWidth() + r.getXpos() <=  this.width + this.xpos) && ( r.getHeight() + r.getYpos() <= this.height + this.getYpos()))
				return true;
		return false;				
	}
	public Boolean touches(Rectangle r){ //check all the points in this rectangle, and see which points are equal to four corners of another rectangle
		for(int i = 0; i < r.getWidth(); i++){ 
			if(check((r.getXpos() + i),r.getYpos()))
				return true;
			else if(check((r.getXpos() + i),(r.getYpos() + r.getHeight())))
				return true;
		}
		for(int i = 0; i < r.getHeight(); i++){
			if(check(r.getXpos(),(r.getYpos() + i)))
				return true;
			else if(check((r.getXpos() + r.getWidth()),(r.getYpos() + i)))
				return true;
		}
		return false;		
	}
	public Boolean check(double x, double y){ //check the specific points in this rectangle whether it's equal to the four corners, which is in another rectangle
		if((x == this.xpos) && (y == this.ypos))
			return true;
		else if((x == this.xpos) && (y == this.ypos + this.height))
			return true;
		else if((x == this.xpos + this.width) && (y == this.ypos))
			return true;
		else if((x == this.xpos + this.width) && (y == this.ypos + this.height))
			return true;
		else 
			return false;
	}
}