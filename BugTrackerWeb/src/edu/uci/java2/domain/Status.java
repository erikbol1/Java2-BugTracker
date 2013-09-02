package edu.uci.java2.domain;

public class Status {

	private int ID;
	private String status;
	
	public String getStatus(){
		return status;
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
		if(obj.getClass()!=Status.class) return false;
		
		if(obj==this) return true;
		
		Status status = (Status)obj;
		return status.getID()==this.getID();
	}

	@Override
	public String toString(){
		return status;
	}
	
}
