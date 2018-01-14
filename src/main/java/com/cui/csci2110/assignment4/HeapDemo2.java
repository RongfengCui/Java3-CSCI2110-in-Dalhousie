package com.cui.csci2110.assignment4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class HeapDemo2 {
	public static void main (String [] args) throws IOException{
		Heap<String> myHeap = new Heap<String>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: "); //just read the pokemon file
		String filename = keyboard.nextLine();	
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()){
			myHeap.add(inputFile.nextLine()); // read the file line by line and add the string to a heap
		}
		inputFile.close();
		PrintWriter outputFile1 = new PrintWriter(new FileWriter("file2"));
		while(myHeap.size() > 0){
			outputFile1.println(myHeap.deleteMax()); // using the deleteMax in heap and get the max as, also put the max to another file
		}
		outputFile1.close();
	}
}
