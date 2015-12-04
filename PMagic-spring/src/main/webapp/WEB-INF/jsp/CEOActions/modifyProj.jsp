<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../save" method="post">
	<input type="hidden" name="projId" value="${currentProject.projId}" />

	<table>
		<tr>
			<td>Project name:</td>
			<td><input type="text" name="prName"
				value="${currentProject.prName}" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description"
				value="${currentProject.description}" /></td>
		</tr>
		<tr>
			<td>Started When:</td>
			<td><input type="text" name="startedWhen"
				value="<fmt:formatDate value="${currentProject.startedWhen}" pattern="dd/MM/yyyy" />" /></td>
		</tr>
	</table>
	<td><a href="../../user/backToIndex">Back to main page</a></td>
	<td><input type="submit" value="Save" /></td>
</form>
