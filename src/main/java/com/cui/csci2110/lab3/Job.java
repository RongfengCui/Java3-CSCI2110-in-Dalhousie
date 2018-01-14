package com.cui.csci2110.lab3;


public class Job {
	private String owner;
	private int jobId;

	public Job(String o, int j) {
		owner = o;
		jobId = j;
	}

	public String getOwner() {
		return owner;
	}

	public int getJobId() {
		return jobId;
	}
}