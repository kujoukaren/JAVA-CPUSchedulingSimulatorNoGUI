/** SJFSchedulingAlgorithm.java
 * 
 * A shortest job first scheduling algorithm.
 *
 * @author: Charles Zhu
 * Spring 2016
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

import com.jimweller.cpuscheduler.Process;

public class SJFSchedulingAlgorithm extends BaseSchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm {
    
	private boolean preemptive;
    private Vector<Process> jobs;
	
	class jobCompare implements Comparator<Process>{
		public int compare(Process p1, Process p2){
			if(p1.getBurstTime() != p2.getBurstTime()){
				return Long.valueOf(p1.getBurstTime()).compareTo(Long.valueOf(p2.getBurstTime()));
			}
			else{
				return Long.valueOf(p1.getPID()).compareTo(Long.valueOf(p2.getPID()));
			}
		}
	}
	
	jobCompare job_compare = new jobCompare();
	
    SJFSchedulingAlgorithm(){
        // Fill in this method
        /*------------------------------------------------------------*/
		activeJob = null;
		preemptive = false;
		jobs = new Vector<Process>();


        /*------------------------------------------------------------*/
    }

    /** Add the new job to the correct queue.*/
    public void addJob(Process p){
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		jobs.add(p);
    	jobs.sort(job_compare);


        /*------------------------------------------------------------*/
    }
    
    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p){
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		if(p == activeJob){
			activeJob = null;
		}
		return jobs.remove(p);


        /*------------------------------------------------------------*/
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
    when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
        throw new UnsupportedOperationException();
    }

    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		if (!isJobFinished() && !isPreemptive()){
			return activeJob;
		}
		else{
			if(jobs.size()>0){
				activeJob = jobs.get(0);
				return activeJob;
			}
			else{
				activeJob = null;
				return activeJob;
			}
		}

        /*------------------------------------------------------------*/
    }

    public String getName(){
        return "Shortest Job First";
    }

    /**
     * @return Value of preemptive.
     */
    public boolean isPreemptive(){
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		return preemptive;


        /*------------------------------------------------------------*/
    }
    
    /**
     * @param v  Value to assign to preemptive.
     */
    public void setPreemptive(boolean  v){
        // Remove the next lines to start your implementation
        //throw new UnsupportedOperationException();
        
        // Fill in this method
        /*------------------------------------------------------------*/
		preemptive = v;


        /*------------------------------------------------------------*/
    }
    
}