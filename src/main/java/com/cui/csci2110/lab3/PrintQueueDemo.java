package com.cui.csci2110.lab3;


public class PrintQueueDemo {
	public static void main(String[] args){
	PrintQueue queue = new PrintQueue();
	queue.lpr("Jack", 101);
	queue.lpr("peter", 102);
	queue.lpr("sarah", 102);
	queue.lpr("Jack", 103);
	queue.lpr("John", 104);
	queue.lpr("Bob", 105);
	queue.lpq();
	queue.lprm(102);
	System.out.println("\n");
	queue.lprmAll("Jack");
	queue.lpq();
	}
}
