package com.cui.csci2110.assignment5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class GraphDemo {
	public static void main(String[] args) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		PrintWriter outputFile1 = new PrintWriter(new FileWriter("file2"));
		System.out.print("Enter the filename to read from: "); //just read the pokemon file
		String filename = keyboard.nextLine();	
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		int num = inputFile.nextInt(); //first read the first line and get a number
		Graph graph = new Graph(num); //then just new a graph object and there is a adjMatrix with a "num" size
		while (inputFile.hasNext()) {
			String firstVertex	= inputFile.next();//read the first character
			String secondVertex = inputFile.next();//read the second character
			int	x =	firstVertex.charAt(0)-65; //change string to int
			int	y =	secondVertex.charAt(0)-65;
			graph.addEdge(x, y); //change 0 to 1
			graph.addEdge(y, x);
		}	
		ArrayList<Integer> list = bfs(0,graph); // assume first node to start
		outputFile1.print("The result is ");
		for(int i = 0; i < list.size(); i++){
			outputFile1.print((char)(list.get(i)+65) + " "); // change int to string again
		}	
		outputFile1.close();
	}
	public static ArrayList<Integer> bfs(int i, Graph g) { //this method just using breath first search
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>(); //final list to return
		boolean[] visited = new boolean[g.getAdjMatrix().length];  //just create a boolean array to include all false
		for(int s = 0; s < g.getAdjMatrix().length; s++){
			visited[s] = false;
		}
		visited[i]=true; //visit the first key, and change false to true
        list1.add(i); // add the first key to list1
        while (list1.size() != 0){
        	int n = list1.remove(0);//remove first item in arraylist
        	list2.add(n); // add to another list
        	ArrayList<Integer> list = findNeighbour(n, g.getAdjMatrix()); //find n's neighbour
        	for(int p = 0; p < list.size(); p++){
        		 if (!visited[list.get(p)])  // if n's neighbour have not visited yet
                 {
                     visited[list.get(p)] = true; //visit it
                     list1.add(list.get(p)); // add n's neighbour to list1 
                 }
        	}
        }
        return list2;
	}
    public static ArrayList<Integer> findNeighbour(int num, int[][] adjMatrix) { // this method just use to find all the neighbour of num 
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < adjMatrix.length; i++){
    		if(adjMatrix[num][i] == 1)
    			list.add(i);  			
    	}
    	for(int i = 0; i < adjMatrix.length; i++){
    		if(adjMatrix[i][num] == 1)
    			list.add(i);  			
    	}   	
    	return list;
    }
}
