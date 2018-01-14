package com.cui.csci2110.assignment2;

import java.util.ArrayList;
public class NHLStats {
	private List<PlayerRecord> playerlist; // aggregate two list which store playerRecord , and another one store teamlist
	private List<Team> teamlist;
	public NHLStats() {
		playerlist = new List<PlayerRecord>();
		teamlist = new List<Team>();
	}

	public List<PlayerRecord> getPlayerlist() {
		return playerlist;
	}
	
	public void setPlayerlist(List<PlayerRecord> playerlist) {
		this.playerlist = playerlist;
	}
	
	public List<Team> getTeamlist() {
		return teamlist;
	}

	public void setTeamlist(List<Team> teamlist) {
		this.teamlist = teamlist;
	}

	public void add(PlayerRecord pr){
		playerlist.add(pr);
	}
	public void add1(Team t){ //add team object to teamlist
		teamlist.add(t);
	}
	public boolean isEmpty(){
		return playerlist.isEmpty();
	}
	
	public boolean contains(PlayerRecord pr){
		return playerlist.contains(pr);
	}
	public boolean contains1(Team t){
		return teamlist.contains(t);
	}
	public PlayerRecord first(){
		return playerlist.first();
	}
	public PlayerRecord next(){	
		return playerlist.next();
	}
	public Team first1(){ // first1 method is just same like to first method
		return teamlist.first();
	}
	public Team next1(){	
		return teamlist.next();
	}
	public void enumerate(){
		playerlist.enumerate();
	}
	
	public ArrayList<PlayerRecord> highestPoint(){
		double max = 0.0, amount;
		ArrayList<PlayerRecord> arraylist = new ArrayList<PlayerRecord>(); // create a arraylist to store playerRecord
		PlayerRecord pr = playerlist.first(); // get the first player in playlist
		while(pr != null){
			amount = pr.getP(); //get the point
			if(amount > max){ // if this player's point higher than max
				arraylist.add(pr); // add this player to arraylist
				max = amount; //and make this player's point to max
			}
			else if(amount == max){ // if equal
				arraylist.add(pr); // add
			}
			pr = playerlist.next();
		}
		return arraylist; // return the arraylist
	}
	public ArrayList<PlayerRecord> maxPenalty(){ // same like the method of highest point
		double max = 0.0, amount;
		ArrayList<PlayerRecord> arraylist = new ArrayList<PlayerRecord>();
		PlayerRecord pr = playerlist.first();
		while(pr != null){
			amount = pr.getPim();
			if(amount > max){
				arraylist.clear();
				arraylist.add(pr);
				max = amount;
			}
			else if(amount == max){
				arraylist.add(pr);
			}
			pr = playerlist.next();
		}
		return arraylist;
	}
	public ArrayList<PlayerRecord> maxWinning(){// same like the method of highest point
		double max = 0.0, amount;
		ArrayList<PlayerRecord> arraylist = new ArrayList<PlayerRecord>();
		PlayerRecord pr = playerlist.first();
		while(pr != null){
			amount = pr.getGwg();
			if(amount > max){
				arraylist.clear();
				arraylist.add(pr);
				max = amount;
			}
			else if(amount == max){
				arraylist.add(pr);
			}
			pr = playerlist.next();
		}
		return arraylist;
	}
	public ArrayList<PlayerRecord> maxShot(){// same like the method of highest point
		double max = 0.0, amount;
		ArrayList<PlayerRecord> arraylist = new ArrayList<PlayerRecord>();
		PlayerRecord pr = playerlist.first();
		while(pr != null){
			amount = pr.getSog();
			if(amount > max){
				arraylist.clear();
				arraylist.add(pr);
				max = amount;
			}
			else if(amount == max){
				arraylist.add(pr);
			}
			pr = playerlist.next();
		}
		return arraylist;
	}
	public ArrayList<Team> maxPenaltyTeam(){// same like the method of highest point, and just change the playerRecord object to the team object
		double max = 0.0, amount;
		ArrayList<Team> arraylist = new ArrayList<Team>();
		Team t = teamlist.first();
		while(t != null){
			amount = t.getSumPenalty();
			if(amount > max){
				arraylist.clear();
				arraylist.add(t);
				max = amount;
			}
			else if(amount == max){
				arraylist.add(t);
			}
			t = teamlist.next();
		}
		return arraylist;
	}
	public ArrayList<Team> maxWinningGoalTeam(){
		double max = 0.0, amount;
		ArrayList<Team> arraylist = new ArrayList<Team>();
		Team t = teamlist.first();
		while(t != null){
			amount = t.getSumWinningGoal();
			if(amount > max){
				arraylist.clear();
				arraylist.add(t);
				max = amount;
			}
			else if(amount == max){
				arraylist.add(t);
			}
			t = teamlist.next();
		}
		return arraylist;
	}
}
