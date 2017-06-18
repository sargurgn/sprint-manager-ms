package com.sprintmanager.app.dataobjects;

import java.util.Date;

public class Sprint {

	private int id;
	private String sprintNumber;
	private String acNumber;
	private Date startDate;
	private Date endDate;

	public Sprint() {

	}

	public Sprint(int id, String sprintNumber, String acNumber, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.sprintNumber = sprintNumber;
		this.acNumber = acNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(String sprintNumber) {
		this.sprintNumber = sprintNumber;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
