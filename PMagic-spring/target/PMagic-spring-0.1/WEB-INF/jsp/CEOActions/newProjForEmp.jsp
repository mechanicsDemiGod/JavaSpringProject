<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../saveNewProj" method="post">
	<input type="hidden" name="empId" value="${empId}" />

	<table>
		<tr>
			<td>ID Of Project:</td>
			<td><input type="text" name="projId"
				value="input number" /></td>
		</tr>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form>
