package com.cui.csci2110.assignment4;

import java.util.Scanner;


public class HeapDemo3 {
	public static void main (String [] args) {
		Heap<Integer> myHeap1 = new Heap<Integer>();
		Heap<Integer> myHeap2 = new Heap<Integer>();
		Heap<Integer> myHeap3 = new Heap<Integer>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integers into the first heap (-1 when done): ");
		Integer num1 = keyboard.nextInt();
		while (num1!=-1)
		{
			myHeap1.add(num1);
			num1 = keyboard.nextInt();
		}
		System.out.print("Enter positive integers into the second heap (-1 when done): ");
		Integer num2 = keyboard.nextInt();
		while (num2 !=-1)
		{
			myHeap1.add(num2);
			num2 = keyboard.nextInt();
		}
		myHeap3 = betterComplexityMerge(myHeap1, myHeap2);
		System.out.println("The heap is: ");
		myHeap3.enumerate();
	}
	public static<T extends Comparable<T>> Heap<T> simpleMerge(Heap<T> heap1, Heap<T> heap2){ // this method of merging is a simple one with O(nlogn) complexity
		Heap<T> myHeap = new Heap<T>(); // create a new heap
		for(int i = 0; i < heap1.size(); i++){
			myHeap.getHeapList().add(heap1.getHeapList().get(i)); // copy one heap to the new heap
		}
		for(int i = 0; i < heap2.size(); i++){
			myHeap.add(heap2.getHeapList().get(i));; // then add another heap to the new heap
		}
		return myHeap;
	}
	
	
	public static Heap<Integer> betterComplexityMerge(Heap<Integer> myHeap1, Heap<Integer> myHeap2){ // this method of merging has a better complexity, which is O(n+m)
		Heap<Integer> myHeap3 = new Heap<Integer>(); // create a new heap
		for(int i=0;i<myHeap1.size();i++){
            myHeap3.getHeapList().add((myHeap1.heapList.get(i))); // copy the first heap to the new heap
        }
        for(int i=0;i<myHeap2.size();i++){
        	myHeap3.getHeapList().add(myHeap2.heapList.get(i)); // copy the second heap to the new heap
        }
        int a = myHeap3.size();  
        for(int i=0;i < a;i++){ // then just heapify the new heap
            heapify(myHeap3,a,i); // scan all the item in heap, and heapify
        }
        return myHeap3;
    }
	public static void heapify(Heap<Integer> myHeap3,int a,int i){
        int max;
        int l = i * 2 + 1; // the index of left node of i
        int r = i * 2 + 2; // the index of right node of i
        if(l >= a || r >= a) // if l or r is larger than the size, just return
        	return;
        else if(myHeap3.getHeapList().get(l) > myHeap3.getHeapList().get(i)){ // if the left node of the item is larger than item
            max = l; // max is the index of the left node
        }
        else if(myHeap3.getHeapList().get(r) > myHeap3.getHeapList().get(i)){// if the right node of the item is larger than item
            max = r; // max is the index of the right node
        }
        else
            max = i; // otherwise i is also as the index of max value
        if(max != i){ // if i is not the max, then change the order
            int num = myHeap3.getHeapList().get(max);  // get the max value     
            myHeap3.getHeapList().set(max,myHeap3.getHeapList().get(i)); // change the item of index i to the the index of max 
            myHeap3.getHeapList().set(i,num); // change the max value to i
            heapify(myHeap3,a,max);
        }
    }
}
