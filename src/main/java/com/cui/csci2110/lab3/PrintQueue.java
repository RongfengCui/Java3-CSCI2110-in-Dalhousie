package com.cui.csci2110.lab3;


public class PrintQueue {
	private GenericQueue<Job> printQueue;
	public PrintQueue() {
		printQueue = new GenericQueue<Job>();
	}
	
	public GenericQueue<Job> getPrintQueue() {
		return printQueue;
	}

	public void lpr(String owner, int jobId){
		printQueue.enqueue(new Job(owner, jobId)); //using enqueue to take a new Job object into the printQueue
	}
	public void lpq(){
		for(int i = 0; i < printQueue.getSize(); i++){ // print each owner and jobID
			System.out.println(printQueue.getQueue().get(i).getOwner() + "\t" + printQueue.getQueue().get(i).getJobId());
		}
	}
	public void lprm(int jobID){ // find the jobID and remove
		for(int i = 0; i < printQueue.getSize(); i++){
			if(jobID == printQueue.getQueue().get(i).getJobId()){
				printQueue.getQueue().remove(i);
				return;
			}	
		}
		System.out.println("Cannot find jobId");
	}
	public void lprmAll(String owner){ // remove all the same owner
		for(int i = 0; i < printQueue.getSize(); i++){
			if(owner.equals(printQueue.getQueue().get(i).getOwner())){
				printQueue.getQueue().remove(i);
			}
		}	
	}
}
