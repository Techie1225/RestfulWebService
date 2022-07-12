<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">STUDENT Registration</h1>
	<frm:form modelAttribute="StudentEntity">
	<table border="1"  align="center">
	<tr>
	<td>id</td>
	<td><frm:input path="id" /></td></tr>
	
		<tr>
			<td>Name</td>
			<td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td>Age Eligibility</td>
			<td><frm:input path="ageEligibitity" /></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><frm:input path="phNumber" /></td>
		</tr>
		<tr>
		<td>Salary</td>
		<td><frm:input path="salary" /></td>
		</tr>
		<tr>
		<td colspan="2"><frm:button type="Submit">Submit</frm:button></td>
		</tr>

	</table>
	</frm:form>
</body>
</html>