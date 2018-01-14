package com.cui.csci2110.assignment4;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;
	
	public Heap()
	{
		heapList = new ArrayList<T>();
	}
	
	public ArrayList<T> getHeapList() {
		return heapList;
	}

	public void setHeapList(ArrayList<T> heapList) {
		this.heapList = heapList;
	}

	public int size()
	{
		return heapList.size();
	}
	
	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}
	
	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}
	
	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);
		
		while (index>0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	
	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
			T ret = heapList.get(0);	//get the item in the root. This is the largest item.
			
			T item = heapList.remove(heapList.size()-1);	//remove the last item.
			
			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.
				
			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;
			
			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
					
					//sift down if necesssary
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}
						
				else if (lIndex < size()) //case 2: item to be sifted down has only left child
				//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
						heapList.set(index, heapList.get(lIndex));
						heapList.set(lIndex,item);
						
						index = lIndex;
					}
				
					else
						found = true;
				}
				else //case 3: item to be sifted down has no children
					found = true;
						
				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}

	}
	public T findMin(){
		if (isEmpty()){ // arraylist is empty just return
			System.out.println("Heap is empty");
			return null;
		}
		else{
			int num1 = heapList.size();
			int num2 = 1;
			while(num2 *2 < num1){
				num2 = num2 * 2; // find the last level of the binary heap
			}
			T min = heapList.get(num2 - 1); // the first item of the last level
			for(int i = num2 - 1; i < heapList.size(); i++){ // compare all the item in last level and find the min
				if(min.compareTo(heapList.get(i)) > 0 )
					min = heapList.get(i);
			}
			return min;
		}	
	}
	public T dequeueMin(){
		int size = heapList.size();
		if(size == 1){
			return heapList.remove(0);
		}
		else if(heapList.indexOf(findMin()) == size - 1){ // if the min is the last item, then just remove the last one
			return heapList.remove(size - 1);
		}
		else{
			int index = heapList.indexOf(findMin()); // return the index of the min index
			int num = heapList.size() - 1; 
			heapList.add(index,heapList.get(num)); // add the last index item to the min item index
			heapList.remove(num+1); // remove the last item
			T item = heapList.remove(index + 1); //remove the min item
			int n = index;
			if(index % 2 == 0){ // if index is a even number just find and compare the index of (index -2)/2
				while(n > 0){
					n = (n -2)/2;
					if(heapList.get(n).compareTo(heapList.get(index)) < 0){ // this if statement just to change the order, until it finds the right spot. 
						heapList.add(n, heapList.get(index)); // the code before if statement end is to change two items order
						T item1 = heapList.remove(n+1);
						heapList.add(index, item1);
						heapList.remove(index+1);
					}					
				}
				return item;
			}
			else { // similar as if statement
				while(n > 0){
					n = (n - 1)/2;
					if(heapList.get(n).compareTo(heapList.get(index)) < 0){ // if index is a odd number just find and compare the index of (index -1)/2
						heapList.add(n, heapList.get(index));
						T item1 = heapList.remove(n+1);
						heapList.add(index, item1);
						heapList.remove(index+1);
					}					
				}
				return item;
			}
		}	
	}
}
