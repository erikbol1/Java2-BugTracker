package edu.uci.java2.domain;

import java.util.Date;

public class Bug {
	
	private int ID;
	private String summary;
	private String description;
	private Priority priority;
	private Status status;
	private Date createdDate;
	private Date lastUpdateDate;
	private User assignee;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
