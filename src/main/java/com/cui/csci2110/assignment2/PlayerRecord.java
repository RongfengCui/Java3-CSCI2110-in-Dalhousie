package com.cui.csci2110.assignment2;


public class PlayerRecord { //create a playerRecord to store the value of file
	private String name,position,team,gp;
	private int g,a,pim,sog,gwg,p;
	public PlayerRecord(String name, String position, String team, String gp, int g, int a, int pim, int sog, int gwg) {
		this.name = name;
		this.position = position;
		this.team = team;
		this.gp = gp;
		this.g = g;
		this.a = a;
		this.pim = pim;
		this.sog = sog;
		this.gwg = gwg;
		this.p = g + a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGp() {
		return gp;
	}
	public void setGp(String gp) {
		this.gp = gp;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getPim() {
		return pim;
	}
	public void setPim(int pim) {
		this.pim = pim;
	}
	public int getSog() {
		return sog;
	}
	public void setSog(int sog) {
		this.sog = sog;
	}
	public int getGwg() {
		return gwg;
	}
	public void setGwg(int gwg) {
		this.gwg = gwg;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	
}
