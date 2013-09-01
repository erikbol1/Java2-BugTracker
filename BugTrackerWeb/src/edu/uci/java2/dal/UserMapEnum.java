package edu.uci.java2.dal;

public enum UserMapEnum {
	
	EMAIL("Email"),
	USERNAME("UserName"),
	PASSWORDHASH("PasswordHash");
	
	private String value;
	
	UserMapEnum(String collumn){
		this.value = collumn;
	}
	
	@Override
	public String toString(){
		return this.value;
	}

}
