package com.cui.csci2110.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1Q2 extends E1Q1{
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.print("Please enter a number: ");
		int num = input.nextInt();
		list = getAllBinaryNumbers(list,num);
		list = pickUpBinaryNumbers(list,num);
		list = printRoute(list);
		System.out.println(getAllRoute(list,num));
	}
	public static List<String> getAllRoute(List<String> list, int num){ //get all the route include diagonal
		ArrayList<String> list1 = new ArrayList<String>();
		int size = list.size();
		for(int i = 0; i < size; i++){
			String str = list.get(i);
			for(int j = 0; j < str.length()-1; j++){
				if(str.charAt(j) != str.charAt(j+1)){
					list1.add(getDiagnalRoute(str,j));
				}	
			}
		}	
		list1 = deletSame(list1);
		list.addAll(list1);
		while (num - 1 > 0) {
			size = list1.size();
			for (int i = 0; i < size; i++) {
				String str = list1.get(i);
				for (int j = 0; j < str.length() - 1; j++) {
					if (str.charAt(j) != str.charAt(j + 1) && str.charAt(j) != 'D' && str.charAt(j+1) != 'D') {
						list1.add(getDiagnalRoute(str, j));
					}
				}
			}
			for(int i =0; i < size; i++){
				list1.remove(0);
			}
			list1 = deletSame(list1);
			list.addAll(list1);
			num--;
		}
		return list;
	}	
	public static String getDiagnalRoute(String str, int num){ // if the string have form like EN or NE,and change it to D
		String s = "";
		for(int i = 0; i < str.length(); i++){
			if(num == i){
				s += "D";
				i++;
			}
			else{
				s += str.charAt(i);
			}
		}
		return s;
	}
	public static ArrayList<String> deletSame(ArrayList<String> list1){ //delete the same route in the arrayList
		for(int i = 0;i<list1.size();i++){
	        for(int j = i+1;j<list1.size();j++){
	        	if(list1.get(i).equals(list1.get(j))){
	        		list1.remove(i);
	                i--;
	                break;
	            }
	        }
		}
		return list1;
	}
}