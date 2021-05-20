package com.mohamed.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mohamed.model.LeaveRequest;

public class TestLeaveRequestManager {

	@Test
	public void testApplyLeaveWithSickLeaveTypeAndValidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("SickLeave");
		String username = "moha2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Successfully Applied!... You have 1 remaining sick leaves", message);
		message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Successfully Applied!... You have 0 remaining sick leaves", message);
		message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("You have used all your sick leaves", message);
	}

	@Test
	public void testApplyLeaveWithCasualLeaveTypeAndValidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("CasualLeave");
		String username = "moha2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Successfully Applied!... You have 1 remaining casual leaves", message);
		message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Successfully Applied!... You have 0 remaining casual leaves", message);
		message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("You have used all your casual leaves", message);
	}

	@Test
	public void testApplyLeaveWithEarnedLeaveTypeAndValidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("EarnedLeave");
		String username = "moha2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Successfully Applied!... You have 0 remaining earned leaves", message);
		message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("You have used all your earned leaves", message);
	}

	@Test
	public void testApplyLeaveWithInvalidLeaveTypeAndValidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("Leave");
		String username = "moha2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("Failed to apply", message);
	}

	@Test
	public void testApplyLeaveWithSickLeaveTypeAndInvalidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("SickLeave");
		String username = "2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("No employee found with given details", message);
	}

	@Test
	public void testApplyLeaveWithCasualLeaveTypeAndInvalidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("CasualLeave");
		String username = "2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("No employee found with given details", message);
	}

	@Test
	public void testApplyLeaveWithEarnedLeaveTypeAndInvalidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("EarnedLeave");
		String username = "2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("No employee found with given details", message);
	}

	@Test
	public void testApplyLeaveWithInvalidLeaveTypeAndInvalidUserdetails() {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setType("Leave");
		String username = "2627";
		String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
		assertEquals("No employee found with given details", message);
	}
}
