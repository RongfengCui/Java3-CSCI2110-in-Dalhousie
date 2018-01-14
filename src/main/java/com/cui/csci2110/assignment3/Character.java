package com.cui.csci2110.assignment3;


public class Character { //this class is to create object about each chararcter in pokemon txt
	private int num; // the number of chararcter which appears in pokemon file
	private String ch; // the character
	private static double total; // the total number of all character in pokemon file
	private String huffman; // the corresponding huffman code for each chararcter in pokemon txt
	public Character(int num, String ch){
		this.num = num;
		this.ch = ch;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public void addNum(){
		num++;
	}
	@Override
	public String toString() {
		return ch + "  " + num;
	}
	public static double getTotal() {
		return total;
	}
	public static void setTotal(double total) {
		Character.total = total;
	}
	public static void addTotal(){
		total++;
	}
	public double getPro() { // this method is to get the probability of each character
		return num/total;
	}
	public String getHuffman() {
		return huffman;
	}
	public void setHuffman(String huffman) {
		this.huffman = huffman;
	}
	
	
}
