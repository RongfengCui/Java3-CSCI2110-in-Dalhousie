package com.cui.csci2110.assignment1;

import java.io.*;



import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author cuirongfeng
 *
 */
public class DNAMatch{
	private static final Logger logger = LoggerFactory.getLogger(DNAMatch.class);
	
	public static void main(String[] args) throws IOException{
		Scanner input  = new Scanner(System.in);
		logger.debug("s");
		System.out.print("Enter the filename to read from: ");
		String filename = input.nextLine();
		String s1 = new Scanner(new File(filename)).useDelimiter("\\A").next(); //Read all the text file in one time
		System.out.print("Enter the test string: ");
		String s2 = input.nextLine();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		if(findSame(s1,s2) == 0)
			System.out.println("Substring " + s2 + " was not found");
		else
			System.out.println("Substring " + s2 + " was found " + findSame(s1,s2) + " times");
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Execution time is " + executionTime + " millisecs");
	}
	/**
	 * 
	 * @param s1  
	 * @param s2
	 * @return
	 */
	public static int findSame(String s1, String s2) {
		int times = 0;
		for (int i = 0; i <= s1.length() - s2.length(); i++) {
		    String substring = s1.substring(i, i + s2.length());
		    if (substring.equals(s2)) {
		        times = times + 1;
		    }
		}
		return times;
	}
}
