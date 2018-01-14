package com.cui.csci2110.lab4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class CountryDemo{
	public static void main (String[] args)throws IOException{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
	
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		List<Country> list = new List<Country>();
		String countryName;
		String capitalName;	
		while (inputFile.hasNext()){	
			countryName = inputFile.nextLine();
			capitalName = inputFile.nextLine();
			Country coun = new Country(countryName,capitalName);
			list.add(coun);
		}
		inputFile.close();
	
		System.out.print("Welcome to the Country-Capital Quiz" + "\n" + "Play? ");
		String answer = keyboard.nextLine();
		while(answer.equals("Yes")){
			Country coun = null;
			Random rand = new Random(); 
			int i = rand.nextInt(list.size()-1); //random from 0 to list.size()-2
			int j = rand.nextInt(2) + 1; //random from 1 and 2
			if(i == 0)
				coun = list.first();
			else{
				coun = list.first();
				for(int z = 0; z < i; z++){
					coun = list.next();			
				}
			}
			if(j == 1){ //if j = 1, answer the country name
				System.out.println("What country has " + coun.getCapitalName() + " as its capital?");
				String answer1 = keyboard.nextLine();
				if(answer1.equals(coun.getCountryName())){ 
					System.out.print("Correct. Play? ");
					answer = keyboard.nextLine();
				}
				else{ 
					System.out.print("Incorrect. The correct answer is " + coun.getCountryName() + ". Play? ");
					answer = keyboard.nextLine();
				}					
			}
			else{ // else answer the capital name
				System.out.println("What is the capital of " + coun.getCountryName() + "?");
				String answer1 = keyboard.nextLine();
				if(answer1.equals(coun.getCapitalName())){
					System.out.print("Correct. Play? ");
					answer = keyboard.nextLine();
				}
				else{
					System.out.print("Incorrect. The correct answer is " + coun.getCapitalName() + ". Play? ");
					answer = keyboard.nextLine();
				}	
			}
		}
		System.out.println("Game Over.");
	}	
}
