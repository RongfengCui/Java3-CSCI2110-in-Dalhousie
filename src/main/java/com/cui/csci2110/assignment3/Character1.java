package com.cui.csci2110.assignment3;


public class Character1 { //this class is just to create object after read the huffman file
	private double pro;
	private String ch;
	private String huffman;
	public Character1(double pro, String ch, String huffman) {
		this.pro = pro;
		this.ch = ch;
		this.huffman = huffman;
	}
	public double getPro() {
		return pro;
	}
	public void setPro(double pro) {
		this.pro = pro;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public String getHuffman() {
		return huffman;
	}
	public void setHuffman(String huffman) {
		this.huffman = huffman;
	}
	
}
