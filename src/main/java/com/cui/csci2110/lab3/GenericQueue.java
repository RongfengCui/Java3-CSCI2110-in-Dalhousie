package com.cui.csci2110.lab3;

import java.util.ArrayList;
public class GenericQueue<T> {
	private ArrayList<T> queue;
	int cursor; 
	public GenericQueue(){
		queue = new ArrayList<T>();
		cursor = -1;
	}
	public void enqueue(T item){ //just use add method in arraylist
		queue.add(item);
	}
	public T dequeue(T item){ //get the first item in arraylist
		T result = null;
		if(queue.size() == 0)
			System.out.println("Cannot dequeue");
		else
			result = queue.remove(0);
		return result;
	}
	public int getSize(){
		return queue.size();
	}
	public boolean isEmpty(){
		return (queue.size() == 0);
	}
	public void clear(){
		queue.removeAll(queue);
	}
	public T peek(){
		T result = null;
		if(queue.size() == 0)
			System.out.println("Cannot peek");
		else
			result = queue.get(0);
		return result;
	}
	public int positionOf(T item){ //return the index number
		for(int i = 0; i < queue.size(); i++){
			if(queue.get(i) == item)
				return i;
		}
		return -1;
	}
	public void remove(T item){
		for(int i = 0; i < queue.size(); i++){
			if(queue.get(i) == item){
				queue.remove(i);
				return;
			}	
		}
		System.out.println("Cannot find this item.");
	}
	public T first(){ //get the first item and set cursor to 0
		if(isEmpty())
			return null;
		else{
			cursor = 0;
			return queue.get(0);
		}			
	}
	public T next(){ //cursor need to add 1 and return the item
		cursor++;
		if(cursor < queue.size()){
			return queue.get(cursor);
		}
		else
			return null;			
	}
	public ArrayList<T> getQueue() {
		return queue;
	}
	public void setQueue(ArrayList<T> queue) {
		this.queue = queue;
	}
	public int getCursor() {
		return cursor;
	}
	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
	
}
