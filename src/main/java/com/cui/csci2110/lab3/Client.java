package com.cui.csci2110.lab3;


import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class Client {
	public static void main(String[] args) throws IOException {
		GenericStack<StudentRecord> stack1 = new GenericStack<StudentRecord>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		StringTokenizer token;
		while (inputFile.hasNext()) {
			String line = inputFile.nextLine();
			token = new StringTokenizer(line, " ");
     		String f = token.nextToken();
			String l = token.nextToken();
			String bString = token.nextToken();
			int i=Integer.parseInt(bString);
			StudentRecord sr = new StudentRecord(f,l,i); //create a new object from StudentRecord.class
			stack1.push(sr); // push the new object into the stack
		}
		inputFile.close();
		GenericStack<String> stack2 = new GenericStack<String>();
		for(int i = stack1.getStack().size() - 1; i >= 0; i--){
			stack2.push(stack1.getStack().get(i).getLastName()); //push the last name from stack1 to stack2
			stack1.pop(); //then pop
		}
		for(int i = stack2.getStack().size() - 1; i >= 0; i--){
			System.out.println(stack2.getStack().get(i)); //print all last name in stack2
		}
	}
}
