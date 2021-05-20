package com.mohamed.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mohamed.model.LeaveRequest;
import com.mohamed.service.LeaveRequestManager;

/**
 * Servlet implementation class ApplyLeaveServlet
 */
public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			// Getting all the parameters from applyleave.jsp
			String username = (String) session.getAttribute("LOGGEDIN_USERNAME");
			String name = request.getParameter("employeename");
			int id = Integer.parseInt(request.getParameter("employeeid"));
			LocalDate fromDate = LocalDate.parse(request.getParameter("fromdate"));
			LocalDate toDate = LocalDate.parse(request.getParameter("todate"));
			String type = request.getParameter("leavetype");
			String reason = request.getParameter("reason");
			// Setting obtained parameter in a LeaveRequest object.
			LeaveRequest leaveRequest = new LeaveRequest();
			leaveRequest.setName(name);
			leaveRequest.setEmployeeId(id);
			leaveRequest.setFromDate(fromDate);
			leaveRequest.setToDate(toDate);
			leaveRequest.setType(type);
			leaveRequest.setReason(reason);
			// Passing LeaveRequest for applying request
			String message = LeaveRequestManager.applyLeaveRequest(leaveRequest, username);
			response.sendRedirect("applyleave.jsp?infoMessage=" + message);
		} catch (Exception e) {
			String message = e.getMessage();
			response.sendRedirect("applyleave.jsp?errorMessage=" + message);
		}
	}

}
