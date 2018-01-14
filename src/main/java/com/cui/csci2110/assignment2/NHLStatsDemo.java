package com.cui.csci2110.assignment2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class NHLStatsDemo{
	public static void main(String [] args) throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		NHLStats ns = new NHLStats();
		String name,position,team,gp; int g,a,pim,sog,gwg;
		PlayerRecord pr=null;
		
		while (inputFile.hasNext()){
			name = inputFile.next(); 
			position = inputFile.next();
			team = inputFile.next();
			gp = inputFile.next();
			g = inputFile.nextInt();
			a = inputFile.nextInt();
			pim= inputFile.nextInt();
			sog = inputFile.nextInt();
			gwg= inputFile.nextInt();
			pr = new PlayerRecord(name,position,team,gp,g,a,pim,sog,gwg); // create each playerRecord object
			ns.add(pr); // add the object to playerlist
			if(!list.contains(team)){ // if arraylist contains the team name
				list.add(team); //add this team name to list
				ns.add1(new Team(team)); // create a team object and add this to teamlist
			}
			Team t = ns.first1(); // get the first team in teamlist
			while(t != null){
				if(t.getTeamName().equals(team)){ // if team name equal to the teamname in teamlist
					t.addPenalty(pr);
					t.addWiningGoal(pr);
					break;
				}
				t = ns.next1();
			} 
		}
		inputFile.close();
		System.out.println();
		System.out.println("Agressive players: "); // print the output below
		for(int i = 0; i < ns.maxPenalty().size(); i++){
			System.out.println(ns.maxPenalty().get(i).getName() + " " + ns.maxPenalty().get(i).getTeam() + "  Penality mins: " + ns.maxPenalty().get(i).getPim());
		}
		System.out.println(" ");
		System.out.println("Most promising players: ");
		for(int i = 0; i < ns.maxShot().size(); i++){
			System.out.println(ns.maxShot().get(i).getName() + " " + ns.maxShot().get(i).getTeam() + "  Num of shots on goals: " + ns.maxShot().get(i).getSog());
		}
		System.out.println(" ");
		System.out.println("Highest points:");
		for(int i = 0; i < ns.highestPoint().size(); i++){
			System.out.println(ns.highestPoint().get(i).getName() + " " + ns.highestPoint().get(i).getTeam() + "  points: " + ns.highestPoint().get(i).getP());
		}
		System.out.println(" ");
		System.out.println("MVP:");
		for(int i = 0; i < ns.maxWinning().size(); i++){
			System.out.println(ns.maxWinning().get(i).getName() + " " + ns.maxWinning().get(i).getName() + "  Num of game wining goals: " + ns.maxWinning().get(i).getGwg());
		}
		System.out.println(" ");
		System.out.println("Agressive Team:");
		for(int i = 0; i < ns.maxPenaltyTeam().size(); i++){
			System.out.println(ns.maxPenaltyTeam().get(i).getTeamName() + "  Most Penalty time: " + ns.maxPenaltyTeam().get(i).getSumPenalty());
		}
		System.out.println(" ");
		System.out.println("Most winning team:");
		for(int i = 0; i < ns.maxWinningGoalTeam().size(); i++){
			System.out.println(ns.maxWinningGoalTeam().get(i).getTeamName() + "  Most winning goals: " + ns.maxWinningGoalTeam().get(i).getSumWinningGoal());
		}
	}
}
