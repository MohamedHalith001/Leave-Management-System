package com.mohamed.model;

import java.time.LocalDate;

import com.mohamed.util.DateValidator;
import com.mohamed.util.StringValidator;

public class LeaveRequest {
	private int leaveId;
	private String name;
	private int employeeId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String type;
	private String reason;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!StringValidator.isValidString(name)) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		if (id < 1000 || id > 9999) {
			throw new IllegalArgumentException("Employee Id should be 4 digit number");
		}
		this.employeeId = id;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		if (!DateValidator.isValidDate(fromDate)) {
			throw new IllegalArgumentException("Date cannot be a past date");
		}
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		if (!DateValidator.isValidDate(toDate)) {
			throw new IllegalArgumentException("Date cannot be a past date");
		}
		this.toDate = toDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (!StringValidator.isValidString(type)) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		if (!StringValidator.isValidString(reason)) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "LeaveRequest [S.No " + leaveId + " Name= " + name + ", Employee Id= " + employeeId + ", From Date= "
				+ fromDate + ", To Date= " + toDate + ", Type= " + type + ", Reason= " + reason + "]";
	}

}
