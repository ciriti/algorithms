package it.car.booking.interview;

import java.util.HashSet;
import java.util.Set;

public class InterviewQuestions {
	
	static class Team {
	    int size; // already filled by the iterator
	    String name; // already filled  by the iterator
	    String parentName; // already filled  by the iterator
	    Set<Team> subteams;
	    
	    public Team(String name, int size, String parentName){
	    	this.name = name;
	    	this.size = size;
	    	this.parentName = parentName;
	    	subteams = new HashSet<Team>();
	    	
	    }
	    public void addSubteam(Team t){
	       subteams.add(t);
	    }
	}
	
	public static void main(){
		
	}

}
