package com.cui.csci2110.lab8;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class HashDemo {
	public static void main(String[] args) throws IOException{
		PrintWriter outputFile = new PrintWriter(new FileWriter("file1"));
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the size of the hash table: ");
		int num1 = keyboard.nextInt();
		ArrayList<LinkedList<Integer>> array = new ArrayList<LinkedList<Integer>>(num1);
		System.out.print("Enter the number of keys to be hashed: ");
		int num2 = keyboard.nextInt();
		int num3 = num2;
		for(int i = 0; i < num1; i++){ //add the number of linkedlist to arraylist based on the size
			array.add(new LinkedList<Integer>());
		}
		while(num2 > 0){
			int val = (int)(Math.random()*10000+1); //random the number
			int index = val % num1; // get index
			array.get(index).add(val); // put the value to linkedlist
			num2--;
		}
		outputFile.println("Hash Table created: \n");
		for(LinkedList<Integer> l: array){ // this for loop just take out all the value of linkedlist in arraylist
			if(l.isEmpty())
				outputFile.println("-->Empty");
			else{
				Node<Integer> cur = l.getFront();
				while(cur != null){
					outputFile.print("-->" + cur.getData());
					cur = cur.getNext();
				}
				outputFile.print("\n");
			}	
		}
		outputFile.println("\nStatistics: ");
		outputFile.println("Table size: " + num1);
		outputFile.println("Number of keys: " + num3);
		outputFile.println("Load factor: " + (double)num3/num1);
		outputFile.println("Number of collisions: " + numOfCollision(array));
		outputFile.println("Longest list: " + longestList(array));
		outputFile.close();
	}	
	public static int numOfCollision(ArrayList<LinkedList<Integer>> array){
		int num = 0;
		for(LinkedList<Integer> l: array){
			if(l.size() > 1) // if the linkedlist have two more node
				num += (l.size() -1); // size minus one and add to num
		}
		return num;
	}
	public static int longestList(ArrayList<LinkedList<Integer>> array){
		int max = 0;
		for(LinkedList<Integer> l: array){ 
			if(l.size() > max)
				max = l.size();
		}
		return max;
	}
}

