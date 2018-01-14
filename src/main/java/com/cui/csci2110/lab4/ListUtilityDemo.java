package com.cui.csci2110.lab4;


public class ListUtilityDemo {
	public static void main(String[] args){
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		list1.addToEnd("A");
		list1.addToEnd("B");
		list1.addToEnd("C");
		list1.addToEnd("D");
		list2.addToEnd("A");
		list2.addToEnd("C");
		list2.addToEnd("E");
		list2.addToEnd("F");
		list2.addToEnd("C");
		list2.addToEnd("C");
		ListUtility.findIntersection(list1, list2).enumerate();
		System.out.println("\n");
		ListUtility.findUnion(list1, list2).enumerate();
		System.out.println("\n");
		ListUtility.chopSkip(list1).enumerate();
		System.out.println("\n");
		ListUtility.interleave(list1, list2).enumerate();
		
	}
}
