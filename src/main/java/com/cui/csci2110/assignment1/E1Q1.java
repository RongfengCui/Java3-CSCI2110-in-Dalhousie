package com.cui.csci2110.assignment1;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
public class E1Q1{
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.print("Please enter a number: ");
		int num = input.nextInt();
		list = getAllBinaryNumbers(list,num);
		list =  pickUpBinaryNumbers(list,num);
		System.out.print(printRoute(list));
	}
	public static List<String> getAllBinaryNumbers(List<String> list, int num){ //This method is to get all the possibility of the binary numbers,such as if num =1,then will get 10,01 
		int i = 1;
		for(int j = num * 2; j > 0; j--){
			i = i * 2;
		}
		for(i = i - 1; i >= 0; i--){
			String bin = Integer.toBinaryString(i); 
			while(bin.length() < num * 2){
				bin = "0"+bin;
			}	
			list.add(bin);
		}
		return list;
	}
	public static List<String> pickUpBinaryNumbers(List<String> list, int num){ //This method is to pick up some binary numbers that do not meet the requirement,such as 1110,0001,0000,1111
		for(int j = 0; j < list.size(); j++){	
			int num1 = 0 , num2 = 0;
			char[] ch=list.get(j).toCharArray();
			for(int i = 0; i < ch.length; i++){
				if(ch[i] == '0')
					num1++;
				else if(ch[i] == '1')
					num2++;
			}
			if(num1 != num || num2 != num){
				list.remove(j);
				j--;
			}				
		}
		return list;
	}
	public static List<String> printRoute(List<String> list){ //change the form 1 and 0 to E and N
		for(int j = 0; j < list.size(); j++){
			String str = "";
			for(int i = 0; i < list.get(j).length(); i++){
				if(list.get(j).charAt(i) == '0')
					str += "E";
				else
					str += "N";
			}	
			list.set(j, str);
		}
		return list;
	}	
}
