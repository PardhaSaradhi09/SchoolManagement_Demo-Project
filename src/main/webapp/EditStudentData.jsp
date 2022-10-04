<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
                  
</head>
<body>
<h1>update Student Data</h1>
	<div class="main">
		<form name="form" action="EditStudentServlet" method="post">
		     
            <input type="number" placeholder="StudentId*" name="studentid" value='<c:out value="${student.sid}" />'>
            <input type="text" placeholder="firstname*" name="FirstName" value='<c:out value="${student.firstName}" />' >
			<input type="text" placeholder="lastname" name="LastName" value='<c:out value="${student.lastName}" />' ><br> 
			<label>Select Gender:</label> 
			<select name="gender" value='<c:out value="${student.gender}" />'>
				<option value="M">Male</option>
				<option value="F">Female</option>
				<option value="O">Others</option>
			</select> <input type="number" placeholder="Age*" name="age" value='<c:out value="${student.age}" />' > 
			<input type="text" placeholder="email" name="email" value='<c:out value="${student.email}" />' > 
			<input type="number" placeholder="mobile" name="phone" value='<c:out value="${student.phone}" />' > 
			<input type="text" placeholder="addressn" name="address" value='<c:out value="${student.address}" />' > 
		    <input type="text" placeholder="Date" name="dateofjoin" value='<c:out value="${student.dateOfJoin}" />' > <br>
			<button type="submit" name="add">submit</button>

		</form>
	

</body>
</html>