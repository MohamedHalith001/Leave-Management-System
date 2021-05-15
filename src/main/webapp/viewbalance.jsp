<%@page import="com.mohamed.model.Employee"%>
<%@page import="com.mohamed.service.EmployeeManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Balance</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String username = (String) session.getAttribute("LOGGEDIN_USERNAME");
Employee employee = EmployeeManager.getEmployee(username);
%>
<main class="container-fluid">
<table class="table table-bordered">
<thead class="table-primary">
<tr>
<th>Name</th>
<th>Id</th>
<th>Sick Leave</th>
<th>Casual Leave</th>
<th>Earned Leave</th>
</tr>
</thead>
<tbody>
<tr><td><%=employee.getName() %></td>
<td><%= employee.getId() %></td>
<td><%=employee.getSickLeave() %></td>
<td><%=employee.getCasualLeave() %></td>
<td><%=employee.getEarnedLeave() %></td>
</tr>
</tbody>
</table>
</main>
</body>
</html>