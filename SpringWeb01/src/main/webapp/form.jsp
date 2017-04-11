<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
</head>
<body>

<h3>Form</h3>

<form action="<c:url value="/hello.controller" />">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
			<td>${errors.name}</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit"></td>
			<td></td>
		</tr>
	</table>
</form>

</body>
</html>