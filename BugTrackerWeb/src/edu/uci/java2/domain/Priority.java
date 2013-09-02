package edu.uci.java2.domain;

public class Priority {
	
	private int ID;
	private String priority;
	
	public String getPriority(){
		return priority;
	}
	
	public int getID(){
		return ID;
	}
	
	@Override
	public int hashCode(){
		return ID;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj.getClass()!=Priority.class) return false;
		
		if(obj==this) return true;
		
		Priority priority = (Priority)obj;
		return priority.getID()==this.getID();
	}
	
	@Override
	public String toString(){
		return priority;
	}

}
