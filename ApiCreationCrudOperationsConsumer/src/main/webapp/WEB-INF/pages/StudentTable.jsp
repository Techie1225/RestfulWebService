<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br />
<h1 align="center">STUDENT LIST</h1>
<br />
<br />
<c:choose>
	<c:when test="${!empty StudentList}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE ELIGIBILITY</th>
				<th>MOBILE NUMBER</th>
				<th>SALARY</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			<c:forEach var="st" items="${StudentList}">

				<tr>
					<td>${st.id}</td>
					<td>${st.name}</td>
					<td>${st.ageEligibitity}</td>
					<td>${st.phNumber}</td>
					<td>${st.salary}</td>
					<td><a href="edit?id=${st.id}">edit</a></td>
					<td><a href="delete?id=${st.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>No Records Found</c:otherwise>
</c:choose>

<c:if test="${!empty id }">
	<h3>Student Enrolled With the ID:: "${id}"</h3>
</c:if>

<br>
<a href="Student_Enrollment">Student Enrollment</a>