<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<title>User Registration Form</title>
<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

#tablehead {
	background-color: lightgreen;
}

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}

input[type=checkbox] {
	display: inline-block;
	margin-right: 190px;
}

#grid {
	background-color: Silver;
}

button {
	padding: 10px;
	margin: 10px;
	color: blue;
	background-color: lavender;
}

body {
	background-color: turquoise;
}
</style>
</head>
<body>
	<div align="center">
		<form:form action="employee" method="post" modelAttribute="employee">
			<h2>Employee Registration</h2>
			<hr>
			<form:label path="empName">
				<b>Employee Name</b>
			</form:label>
			<form:input path="empName" maxlength="100"></form:input>
			<br />

			<form:label path="empDateOfJoin">
				<b>Date of Joining </b>(dd/MM/yyyy)
			</form:label>
			<form:input path="empDateOfJoin" maxlength="10"></form:input>
			<br />

			<form:label path="empNo">
				<b>Employee Number</b>
			</form:label>
			<form:input path="empNo"  type ="number" maxlength="10"></form:input>
			<br />

			<form:label path="empDepartCode">
				<b>Department </b>
			</form:label>
			<form:select path="empDepartCode">
				<option value="AD">Administration</option>
				<option value="IT">Information technology</option>
				<option value="HD">Help Desk</option>
				<option value="HR">Human Resource</option>
				<option value="OP">Operation</option>
			</form:select>
			<br />

			<form:label path="salary">
				<b>Salary </b>
			</form:label>
			<form:input type="number"  path="salary" maxlength="10"></form:input>
			<br />
			<form:button type="submit">Save</form:button>
			<form:button type="reset">Clear</form:button>
		</form:form>

	</div>

	<div align="center">
		<form:form action="employees" name="myForm" method="get"
			modelAttribute="employees">
			<p>List of Registered employee</p>
			<table border="1">
				<tr id="tablehead">
					<th>Employee Id</th>
					<th>Employee name</th>
					<th>Employee Number</th>
					<th>Date of Join</th>
					<th>Department</th>
					<th>Salary</th>
					<th>Actions</th>
				</tr>
				<c:if test="${not empty employees}">
					<c:forEach items="${employees}" var="employees">
						<tr id="grid">
							<td><c:out value="${employees.id}" /></td>
							<td><c:out value="${employees.empName}" /></td>
							<td><c:out value="${employees.empNo}" /></td>
							<td><c:out value="${employees.empDateOfJoin}" /></td>
							<td><c:out value="${employees.empDepartCode}" /></td>
							<td><c:out value="${employees.salary}" /></td>
							<td><a
								href="${pageContext.request.contextPath}/${employees.id}">Update</a>
								| <a
								href="${pageContext.request.contextPath}/employee/${employees.id}"
								onclick="return confirm('Are you sure you want to delete ${employees.empName} ?');">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</form:form>
	</div>
	<div>
		<br>
		<p align="center">Search By Number</p>
	</div>
	<div align="center">
		<form:form action="/employee/withNumber" method="get" modelAttribute="searchemployee">
			<input type="number" name="empNo" /> <input type="submit"
				value="SearchByNumber" />
		</form:form>
	</div>

	<div>
		<br>
		<p align="center">Search By Name</p>
	</div>
	<div align="center">
		<form:form action="/employee/withName" method="get"
			modelAttribute="searchemployee">
			<input type="text" name="empName" />
			<input type="submit" value="SearchByName" />
		</form:form>
	</div>


	<div align="center">
	<table border="1">
				<tr id="tablehead">
					<th>Employee Id</th>
					<th>Employee name</th>
					<th>Employee Number</th>
					<th>Date of Join</th>
					<th>Department</th>
					<th>Salary</th>
				</tr>
				<c:if test="${not empty searchemployee}">
					<c:forEach items="${searchemployee}" var="searchemployee">
						<tr id="grid">
							<td><c:out value="${searchemployee.id}" /></td>
							<td><c:out value="${searchemployee.empName}" /></td>
							<td><c:out value="${searchemployee.empNo}" /></td>
							<td><c:out value="${searchemployee.empDateOfJoin}" /></td>
							<td><c:out value="${searchemployee.empDepartCode}" /></td>
							<td><c:out value="${searchemployee.salary}" /></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
	</div>
</body>
</html>