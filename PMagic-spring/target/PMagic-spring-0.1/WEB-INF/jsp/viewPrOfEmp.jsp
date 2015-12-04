<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
	<tr>
		<td>Project ID</td>
		<td>Project Name</td>
		<td>Project Description</td>
	</tr>
	<input type="hidden" name="empId" value="${empId}" />
	<c:forEach items="${prOfEmp}" var="project">
		<tr>
			<td><c:out value="${project.projId}" /></td>
			<td><c:out value="${project.prName}" /></td>
			<td><c:out value="${project.description}" /></td>
		</tr>
	</c:forEach>
</table>

<a href="../assignNewProj/${empId}">AssignNewProj</a>