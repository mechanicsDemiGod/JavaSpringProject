<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="../user/doLogin" method="post">

	<table>
		<tr>
			<td>Mail: </td>
			<td><input type="text" name="mail" value="${currentUser.mail}" /></td>
		</tr>
		<tr>
			<td>Pass: </td>
			<td><input type="password" name="pass" value = "${currentUser.pass}" /></td>
		</tr>

	</table>

	<input type="submit" value="Login" />

</form>