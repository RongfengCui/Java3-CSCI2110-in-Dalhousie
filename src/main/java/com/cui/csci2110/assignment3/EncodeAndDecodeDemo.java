package com.cui.csci2110.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class EncodeAndDecodeDemo {
	public static void main (String [] args) throws IOException{
		ArrayList<Character1> list1 = new ArrayList<Character1>();
		PrintWriter outputFile1 = new PrintWriter(new FileWriter("Encode"));
		File file = new File("Huffman");
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()){ //step5, just read the huffman txt and create object from character1
			String ch = inputFile.next();
			Double b = inputFile.nextDouble();
			String huff = inputFile.next();
			Character1 c = new Character1(b,ch,huff);
			list1.add(c); // add all the object to list1
		}
		inputFile.close();
		File file1 = new File("Pokemon");
		Scanner inputFile1 = new Scanner(file1);
		while (inputFile1.hasNextLine()){ //here is to start to write encode file
			String s = inputFile1.nextLine(); //read each line of pokemon file
			char [] c = s.toCharArray(); //make it to char array
			for(int i = 0; i < c.length; i++){
				for(int j = 0; j < list1.size(); j++){
					char [] c1 =  list1.get(j).getCh().toCharArray();
					if(c[i] == c1[0]) //if equals, convert character to huffman code
						outputFile1.print(list1.get(j).getHuffman());
					if(c[i] == ' '){ // add space
						outputFile1.print(" ");
						break;
					}	
				}
			}	
			outputFile1.print("\r\n");	// to next new line
		}
		outputFile1.close();
		File file2 = new File("Encode");
		Scanner inputFile2 = new Scanner(file2);
		PrintWriter outputFile2 = new PrintWriter(new FileWriter("Decode"));
		while (inputFile2.hasNextLine()){ //here is start to write decode file
			String s = inputFile2.nextLine(); //read each line of encode file
			int num = 0; //num is to control the position of string s to read just by using substring
			while(num != s.length()){
				for(int z = 0; z < list1.size(); z++){
					if(num +1 <= s.length() && s.substring(num,num +1).equals(" ")){
						num++;
						outputFile2.print(" "); // add space
					}
					if(s.substring(num).indexOf(list1.get(z).getHuffman()) == 0){ // find the corrsponding huffman code and convert it to character
						outputFile2.print(list1.get(z).getCh());
						num += list1.get(z).getHuffman().length();
					}	
			    }	
			}			
			outputFile2.print("\r\n");
		}
		inputFile2.close();
		outputFile2.close();
	}
}
