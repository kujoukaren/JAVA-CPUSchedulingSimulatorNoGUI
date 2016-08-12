/** RoundRobinSchedulingAlgorithm.java
 * 
 * A scheduling algorithm that randomly picks the next job to go.
 *
 * @author: Kyle Benson
 * Winter 2013
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class RoundRobinSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    /** the time slice each process gets */
    private int quantum;
	
	private Vector<Process> jobs;
	private int index;
	private int c;
	
    RoundRobinSchedulingAlgorithm(){
        // Fill in this method
        /*------------------------------------------------------------*/
		activeJob = null;
		quantum = 10;
		jobs = new Vector<Process>();
		index = -1;
		c = quantum;
        /*------------------------------------------------------------*/
    }

    /** Add the new job to the correct queue. */
    public void addJob(Process p) {
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		jobs.add(p);

        /*------------------------------------------------------------*/
    }

    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p) {
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		int temp_index = jobs.indexOf(p);
		
		boolean result = jobs.remove(p);
		
		if(index >= temp_index && temp_index != -1){
			if(index == temp_index){
				c = 0;
			}
			index--;
			if (index >= 0 && index < jobs.size()){
				activeJob = jobs.get(index);
			}
			else{
				activeJob = null;
			}
		}
		return result;

        /*------------------------------------------------------------*/
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
    when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get the value of quantum.
     * 
     * @return Value of quantum.
     */
    public int getQuantum() {
        return quantum;
    }

    /**
     * Set the value of quantum.
     * 
     * @param v
     *            Value to assign to quantum.
     */
    public void setQuantum(int v) {
        this.quantum = v;
    }

    /**
     * Returns the next process that should be run by the CPU, null if none
     * available.
     */
    public Process getNextJob(long currentTime) {
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		c--;
		
		if(!isJobFinished() && index >=0 && c>0){
			return activeJob;			
		}
		else{
			if(jobs.size() > 0){
				if(index>=0 && index<(jobs.size()-1)){
					index++;
					activeJob = jobs.get(index);
					c = quantum;
					return activeJob;
				}
				else{
					index = 0;
					activeJob = jobs.get(index);
					c = quantum;
					return activeJob;
				}
			}
			else{
				activeJob = null;
				return activeJob;
			}
		}

        /*------------------------------------------------------------*/
    }

    public String getName() {
        return "Round Robin";
    }
    
}