package com.cui.csci2110.lab3;


public class Point<T> { //using generic create a point class
	private T xpos;
	private T ypos;	
	public Point(T xpos, T ypos){
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public T getXpos() {
		return xpos;
	}

	public void setXpos(T xpos) {
		this.xpos = xpos;
	}

	public T getYpos() {
		return ypos;
	}

	public void setYpos(T ypos) {
		this.ypos = ypos;
	}
	
	public String toString(){
		return "XPOS: " + xpos + " YPOS: " + ypos;
	}
}