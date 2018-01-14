package com.cui.csci2110.assignment2;


public class Team {
	private int sumPenalty; // it has total penalty and winning goals in field
	private int sumWinningGoal;
	private String teamName;
	public Team(String name) { // each team has its own name
		sumPenalty = 0;
		sumWinningGoal = 0;
		teamName = name;
	}
	public void addPenalty(PlayerRecord pr){ // add the penalty
		sumPenalty +=pr.getPim();
	}
	public void addWiningGoal(PlayerRecord pr){ // add the winning goals
		sumWinningGoal +=pr.getGwg();
	}
	public int getSumPenalty() {
		return sumPenalty;
	}
	public void setSumPenalty(int sumPenalty) {
		this.sumPenalty = sumPenalty;
	}
	public int getSumWinningGoal() {
		return sumWinningGoal;
	}
	public void setSumWinningGoal(int sumWinningGoal) {
		this.sumWinningGoal = sumWinningGoal;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
