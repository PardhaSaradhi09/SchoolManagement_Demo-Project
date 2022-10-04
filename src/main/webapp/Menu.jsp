<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Menu Page</title>
<link rel="stylesheet" type="text/css" href="menu.css">
</head>
<body>
	<div class="fixed-header">
		<div class="navbar">
			<a href="#home">Home</a> 
			<a href="#news">About us</a>
			<div class="dropdown">
				<button class="dropbtn">
					Servies <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="AddStudentServlet">Add Student</a> 
					<a href="GetStudentServlet">Show all Student</a>
					<a href="GetStudentCourseServlet">Show all Student Course</a>
               </div>
			</div>
			<a href="LogOutServlet">Logout</a>
		    </div>
	</div>
	<div class="container">
		<p style="text-decoration-color: blue; text-decoration-style: bold;">
			Welcome to
			<c:out value="${user}" />
		</p>
	</div>
	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2022 My School</div>
	</div>
</body>
</html>