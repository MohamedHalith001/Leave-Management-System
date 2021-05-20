<%@page import="com.mohamed.model.Employee"%>
<%@page import="com.mohamed.service.EmployeeManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Apply Leave</title>
</head>
<body>
<%
String username = (String) session.getAttribute("LOGGEDIN_USERNAME");
Employee employee = EmployeeManager.getEmployee(username);
if(employee!=null){
%>
<jsp:include page="header.jsp"></jsp:include>
<main class="container-fluid">
<jsp:include page="message.jsp"></jsp:include>
<form action="ApplyLeaveServlet" method="POST">
<label>Employee Name</label>
<input type="text" name="employeename" id="employeename" value="<%=employee.getName() %>" 
	readonly required/><br/>
<label>Employee Id</label>
<input type="text" name="employeeid" id="employeeid" value="<%= employee.getId() %>"
	readonly required/><br/>
<label>From Date</label>
<input type="date" name="fromdate" id="fromdate" required/><br/>
<label>To Date</label>
<input type="date" name="todate" id="todate" required/><br/>
<label>Type</label>
<select name="leavetype" required>
<option value="" disabled selected>-----SELECT LEAVE TYPE-----</option>
<option value="SickLeave">Sick Leave</option>
<option value="CasualLeave">Casual Leave</option>
<option value="EarnedLeave">Earned Leave</option>
</select><br/>
<label>Reason</label>
<textarea name="reason" required></textarea>
<input type="submit">
</form>
</main>
<%} %>
<script type="text/javascript">
let date = new Date().toJSON().substr(0,10);
let mindate = document.getElementById("fromdate");
let todate = document.getElementById("todate");
mindate.setAttribute("value",date);
mindate.setAttribute("min",date);
todate.setAttribute("value",date);
mindate.addEventListener('input',function(){
	let day = (mindate.value);
	todate.setAttribute("min",day);
	todate.setAttribute("value",day);
});
</script>
</body>
</html>