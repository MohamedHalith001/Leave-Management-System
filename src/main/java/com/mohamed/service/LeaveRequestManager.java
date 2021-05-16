package com.mohamed.service;

import java.util.ArrayList;
import java.util.List;

import com.mohamed.model.Employee;
import com.mohamed.model.LeaveRequest;

public class LeaveRequestManager {
	private LeaveRequestManager() {
		// Default Constructor
	}

	private static final List<LeaveRequest> requestList = new ArrayList<LeaveRequest>();

	public static String applyLeaveRequest(LeaveRequest leaveRequest, String username) {
		String message = "Failed to apply";
		String type = leaveRequest.getType();
		try {
			Employee employee = EmployeeManager.getEmployee(username);
			if (employee == null) {
				throw new NullPointerException();
			}
			switch (type) {
			case "SickLeave":
				int sickLeave = employee.getSickLeave();
				if (sickLeave != 0) {
					sickLeave -= 1;
					employee.setSickLeave(sickLeave);
					message = "Successfully Applied!... You have " + sickLeave + " remaining sick leaves";
				} else {
					message = "You have used all your sick leaves";
				}
				break;
			case "CasualLeave":
				int casualLeave = employee.getCasualLeave();
				if (casualLeave != 0) {
					casualLeave -= 1;
					employee.setCasualLeave(casualLeave);
					message = "Successfully Applied!... You have " + casualLeave + " remaining casual leaves";
				} else {
					message = "You have used all your casual leaves";
				}
				break;
			case "EarnedLeave":
				int earnedLeave = employee.getEarnedLeave();
				if (earnedLeave != 0) {
					earnedLeave -= 1;
					employee.setEarnedLeave(earnedLeave);
					message = "Successfully Applied!... You have " + earnedLeave + " remaining earned leaves";
				} else {
					message = "You have used all your earned leaves";
				}
				break;
			}
			leaveRequest.setLeaveId(requestList.size() + 1);
			requestList.add(leaveRequest);
		} catch (Exception e) {
			message = "No employee found with given details";
		}
		return message;
	}
}
