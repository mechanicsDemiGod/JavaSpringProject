<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table>
		<tr>
			<td>empId</td>
			<td>firstName</td>
			<td>lastName</td>
			<td>hourRate</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.empId}" /></td>
				<td><c:out value="${employee.firstName}" /></td>
				<td><c:out value="${employee.lastName}" /></td>
				<td><c:out value="${employee.hourRate}" /></td>
				<td><a href="modify/${user.empId}">Modify</a></td>	
			</tr>
		</c:forEach>
	</table>