package com.cui.csci2110.assignment1;

import java.util.Scanner;
public class StringMatch {
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s1 = input.nextLine();
		System.out.print("Enter a substring: ");
		String s2 = input.nextLine();
		if(findSame(s1,s2) == 0)
			System.out.println("No matches - substring " + s2 + " was not found in " + s1);
		else
			System.out.println("Substring " + s2 + " was found in " + s1 + " "+ findSame(s1,s2) + " times");
		
	}
	public static int findSame(String s1, String s2) {
		int times = 0;
		for (int i = 0; i <= s1.length() - s2.length(); i++) {
		    String substring = s1.substring(i, i + s2.length()); // get the same length as s2
		    if (substring.equals(s2)) { //compare with s2
		        times = times + 1;
		    }
		}
		return times;
	}
}
