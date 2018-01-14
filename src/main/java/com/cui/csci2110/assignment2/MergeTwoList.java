package com.cui.csci2110.assignment2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MergeTwoList {
	public static <T extends Comparable<T>> OrderedList<T> merge (OrderedList<T> list1, OrderedList<T> list2){
		OrderedList<T> list3 = new OrderedList<T>(); // create a third list
		T f1 = list1.first(); // f1 is the first item in list1
		T f2 = list2.first(); // f2 is the first item in list2
		while(f1 != null || f2 != null){
			if(f1.compareTo(f2) < 0){ // if f1 is smaller than f2
				list3.add(list3.size(), f1); // list3 add f1
				f1 = list1.next(); // f1 equal to next item in list1
			}
			else if(f1.compareTo(f2) > 0){ //just opposite
				list3.add(list3.size(), f2);
				f2 = list2.next();
			}
			else{
				list3.add(list3.size(), f1); // if two items are equal, add f1 to list3
				f1 = list1.next(); // both move next
				f2 = list1.next();
			}
			if(f1 != null && f2 == null){ // if f2 is null means list2 runs out, then add rest of list1 to the list3
				while(f1 != null){
					list3.add(list3.size(), f1);
					f1 = list1.next();
				}
			}
			else if(f1 == null && f2 != null){
				while(f2 != null){
					list3.add(list3.size(), f2);
					f2 = list2.next();
				}
			}
		}	
		return list3;
	}
	public static void main(String [] args) throws IOException{
		OrderedList<String> list1 = new OrderedList<String>();
		OrderedList<String> list2 = new OrderedList<String>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the first filename to read from: ");
		String filename = keyboard.nextLine();		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);				
		while (inputFile.hasNext())
			list1.insert(inputFile.next());  // read the file, and insert to the list1
		inputFile.close();
		System.out.print("Enter the second filename to read from: ");
		String filename1 = keyboard.nextLine();		
		File file1 = new File(filename1);
		Scanner inputFile1 = new Scanner(file1);	
		while (inputFile1.hasNext())
			list2.insert(inputFile1.next());  // read the file, and insert to the list2
		inputFile1.close();
		list1.enumerate(); // enumerate list1
		list2.enumerate();
		MergeTwoList.merge(list1, list2).enumerate();;
	}
}
