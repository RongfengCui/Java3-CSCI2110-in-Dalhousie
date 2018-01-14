package com.cui.csci2110.assignment5;


public class Graph { //this class just include a adjMatrix with a size which is a given number
	private int num;
	private int[][] adjMatrix;	 
	 
	public Graph(int num){
		this.num = num;
	    adjMatrix = new int[num][num];
	}   
	
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public void addEdge(int v, int w){ //just find the position and change 0 to 1
		adjMatrix[v][w] = 1;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}
