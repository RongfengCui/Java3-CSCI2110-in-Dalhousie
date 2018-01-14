package com.cui.csci2110.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class HuffmanDemo {
	public static void main (String [] args) throws IOException{
		ArrayList<BinaryTree<Character>> list3 = new ArrayList<BinaryTree<Character>>();
		ArrayList<BinaryTree<Character>> list4 = new ArrayList<BinaryTree<Character>>();
		ArrayList<Character> list5 = new ArrayList<Character>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: "); //just read the pokemon file
		String filename = keyboard.nextLine();	
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()){
			String s = inputFile.next(); //read each word in pokemon file
			char [] c = s.toCharArray(); //make the word to char array
			for(int z = 0; z < c.length; z++){ //get each character of the word
				String str = String.valueOf(c[z]);
				if(!list1.contains(str)){
					list1.add(str);
					Character ch = new Character(0, str); //create the character object to store the new character
					list2.add(ch); //put the object to list2
				}
				for(int i = 0; i < list2.size(); i++){ //this for loop just add the total  number of same character appears in pokemon file
					if(list2.get(i).getCh().equals(str)){
						list2.get(i).addNum();	
						Character.addTotal(); // also add the total number of all character
					}	
				}
			}
		}
		inputFile.close();
		list5.addAll(list2); //copy list2 which has all the character object to list5, list5 will use after
		while(list2.size() != 0){ // this while loop is to remove all the character object to list3, and list3 is store the BinaryTree<Character> object
			double min = Double.MAX_VALUE;
			Character c = null;
			for(int i = 0; i < list2.size(); i++){
				if(list2.get(i).getPro() <= min){
					min = list2.get(i).getPro();
					c = list2.get(i);
				}	
			}
			BinaryTree<Character> b = new BinaryTree<Character>();
			b.setData(c);
			list3.add(b);
			list2.remove(c);
		}
		BinaryTree<Character> t3 = list3.remove(0); //from here is going to implement the step3 of ass
		BinaryTree<Character> t4 = list3.remove(0); // first is to take and remove first and second item in list3
		BinaryTree<Character> b1 = new BinaryTree<Character>(); //create a new BinaryTree<Character> object
		b1.setData(new Character(t3.getData().getNum()+t4.getData().getNum(),"0")); // add the total number of first and second item in list3 and make it become a new number to a new item
		b1.attachLeft(t3);
		b1.attachRight(t4);
		list4.add(b1); //add it to list4
		while(list3.size() != 0){ //this while loop is exactly like what the step3 tell us to do in ass
			BinaryTree<Character> t1 = null;
			BinaryTree<Character> t2 = null;
			if(list4.size() > 0){
				if(list3.get(0).getData().getNum() > list4.get(0).getData().getNum()) //compare two list
					t1 = list4.remove(0); // t1 is the smaller one
				else
					t1 = list3.remove(0);
			}	
			if(list3.size() == 0)	
				t2 = list4.remove(0);
			else if(list4.size() == 0)
				t2 = list3.remove(0);
			else{
				if(list3.get(0).getData().getNum() > list4.get(0).getData().getNum())
					t2 = list4.remove(0); // t2 is second smaller one
				else
					t2 = list3.remove(0);	
			}
			BinaryTree<Character> p = new BinaryTree<Character>();
			p.setData(new Character(t1.getData().getNum()+t2.getData().getNum(),"0"));
			p.attachLeft(t1);
			p.attachRight(t2);
			list4.add(p);
		}
		while(list4.size() != 1){ //after this while loop the list4 will have one binarytree object which has all character in this tree
			BinaryTree<Character> t1 = list4.remove(0);
			BinaryTree<Character> t2 = list4.remove(0);
			BinaryTree<Character> p = new BinaryTree<Character>();
			p.attachLeft(t1);
			p.attachRight(t2);
			list4.add(p);
		}
		String[] s = findEncoding(list4.get(0)); //from here is going to the step4 of ass which using the findencoding method to get the huffamn code
		for(int i = 0; i < list5.size(); i++){
			char[] b=list5.get(i).getCh().toCharArray();
			list5.get(i).setHuffman(s[(byte)b[0]]);  //here just set corresponding huffman code to each character
		}
		PrintWriter outputFile = new PrintWriter(new FileWriter("Huffman")); //write the file to huffman file
		for (Character c : list5) {
		    outputFile.println(c.getCh() + "\t" +String.format("%.3f",c.getPro()) + "\t\t" + c.getHuffman()); 
		}	
		outputFile.close(); //then please turn to the EncodeAndDecode class

	}
	
	public static void findEncoding(BinaryTree<Character> t, String[] a, String prefix){
		 if(t.getLeft()==null&& t.getRight()==null) {
			 	 char[] b=t.getData().getCh().toCharArray();
				 a[(byte)(b[0])]= prefix;
		 }
		 else {
			 findEncoding(t.getLeft(), a, prefix+"0");
			 findEncoding(t.getRight(), a, prefix+"1");
		 }
	}
	
	public static String[] findEncoding(BinaryTree<Character> t) {
		 String[] result = new String[500];
		 findEncoding(t, result, "");
		 return result;
	}
}
