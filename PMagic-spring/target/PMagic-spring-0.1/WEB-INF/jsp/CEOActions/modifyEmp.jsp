<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../save" method="post">
	<input type="hidden" name="empId" value="${currentEmployee.empId}" />

	<table>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstName"
				value="${currentEmployee.firstName}" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName"
				value="${currentEmployee.lastName}" /></td>
		</tr>
		<tr>
			<td>Hour Rate:</td>
			<td><input type="text" name="hourRate"
				value=<fmt:formatNumber type = "number" groupingUsed = "false"
				              value = "${currentEmployee.hourRate}" /> /></td>
		</tr>
		<tr>
			<td><a href="../../user/backToIndex">Back to main page</a></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form>
