<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}

input[type=checkbox] {
	display: inline-block;
	margin-right: 190px;
}

button {
	padding: 10px;
	margin: 10px;
	color: blue;
	background-color: lavender;
}

body {
	background-color: lavender;
}
</style>
<body>
<div align="center">
	<form:form action="employee" method="post" modelAttribute="employee">
	
			<h1>Update Employee</h1>
			<hr>
			<form:label path="empName">
				<b>Employee Id</b>
			</form:label>
			<form:input path="id" maxlength="100" readonly="true"></form:input>
			<br />
			<form:label path="empName">
				<b>Employee Name</b>
			</form:label>
			<form:input path="empName" maxlength="100"></form:input>
			<br />

			<form:label path="empDateOfJoin">
				<b>Date of Joining </b>(dd/MM/yyyy)
			</form:label>
			<form:input path="empDateOfJoin" maxlength="10" ></form:input>
			<br />

			<form:label path="empNo">
				<b>Employee Number</b>
			</form:label>
			<form:input path="empNo" maxlength="10" readonly="true"></form:input>
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
			<form:input path="salary" maxlength="10"></form:input>
			<br />
			<form:button type="submit" class="registerbtn">Save</form:button>
	</form:form>
	</div>
	<div align="center"></div>
	<a  href="/employee">Go Back</a>
</body>
</html>