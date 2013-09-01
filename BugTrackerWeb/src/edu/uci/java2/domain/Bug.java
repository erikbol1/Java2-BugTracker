package edu.uci.java2.domain;

import java.util.Date;

public class Bug {
	
	private int ID;
	private String summarry;
	private String description;
	private int priority;
	private int status;
	private Date createdData;
	private Date lastUpdateDate;
	private User assignee;
	
	public int getID() {
		return ID;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedData() {
		return createdData;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	public String getSummarry() {
		return summarry;
	}
	public void setSummarry(String summarry) {
		this.summarry = summarry;
	}

}
