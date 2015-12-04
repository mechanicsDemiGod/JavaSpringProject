<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
	<tr>
		<td>project ID</td>
		<td>Name</td>
		<td>Description</td>
		<td>startedWhen</td>
		<td>Action</td>
	</tr>
	<c:forEach items="${projects}" var="project">
		<tr>
			<td><c:out value="${project.projId}" /></td>
			<td><c:out value="${project.prName}" /></td>
			<td><c:out value="${project.description}" /></td>
			<td><c:out value="${project.startedWhen}" /></td>
			<td><a href="view/${project.projId}">Modify</a></td>
			<td><a href="viewEmployees/${project.projId}">View Employees</a></td>
		</tr>
	</c:forEach>

</table>
<a href="view/0">New</a>