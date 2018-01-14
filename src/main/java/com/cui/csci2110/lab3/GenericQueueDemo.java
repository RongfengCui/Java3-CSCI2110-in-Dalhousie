package com.cui.csci2110.lab3;


public class GenericQueueDemo {
	public static void main(String[] args){
		GenericQueue<String> queue = new GenericQueue<String>();
		queue.enqueue("apple");
		queue.enqueue("pear");
		queue.enqueue("pen");
		System.out.println(queue.peek());
		System.out.println(queue.first());
		System.out.println(queue.next());
	}
}
