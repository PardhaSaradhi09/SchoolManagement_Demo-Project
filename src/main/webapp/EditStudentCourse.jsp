<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Update.css">
<style type="text/css">
 @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap');

.wrapper{
  max-width: 500px;
  width: 100%;
  background: #fff;
  margin: 50px auto;
  box-shadow: 2px 2px 4px rgba(0,0,0,0.125);
  padding: 30px;
}

.wrapper .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 25px;
  color: #fec107;
  text-transform: uppercase;
  text-align: center;
}

.wrapper .form{
  width: 100%;
}

.wrapper .form .inputfield{
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.wrapper .form .inputfield label{
   width: 200px;
   color: #757575;
   margin-right: 10px;
  font-size: 14px;
}

.wrapper .form .inputfield .input,
.wrapper .form .inputfield .textarea{
  width: 100%;
  outline: none;
  border: 1px solid #d5dbd9;
  font-size: 15px;
  padding: 8px 10px;
  border-radius: 3px;
  transition: all 0.3s ease;
}

.wrapper .form .inputfield .textarea{
  width: 100%;
  height: 125px;
  resize: none;
}

.wrapper .form .inputfield .custom_select{
  position: relative;
  width: 100%;
  height: 37px;
}

.wrapper .form .inputfield .custom_select:before{
  content: "";
  position: absolute;
  top: 12px;
  right: 10px;
  border: 8px solid;
  border-color: #d5dbd9 transparent transparent transparent;
  pointer-events: none;
}

.wrapper .form .inputfield .custom_select select{
  -webkit-appearance: none;
  -moz-appearance:   none;
  appearance:        none;
  outline: none;
  width: 100%;
  height: 100%;
  border: 0px;
  padding: 8px 10px;
  font-size: 15px;
  border: 1px solid #d5dbd9;
  border-radius: 3px;
}


.wrapper .form .inputfield .input:focus,
.wrapper .form .inputfield .textarea:focus,
.wrapper .form .inputfield .custom_select select:focus{
  border: 1px solid #fec107;
}

.wrapper .form .inputfield p{
   font-size: 14px;
   color: #757575;
}
.wrapper .form .inputfield .check{
  width: 15px;
  height: 15px;
  position: relative;
  display: block;
  cursor: pointer;
}
.wrapper .form .inputfield .check input[type="checkbox"]{
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
}
.wrapper .form .inputfield .check .checkmark{
  width: 15px;
  height: 15px;
  border: 1px solid #fec107;
  display: block;
  position: relative;
}
.wrapper .form .inputfield .check .checkmark:before{
  content: "";
  position: absolute;
  top: 1px;
  left: 2px;
  width: 5px;
  height: 2px;
  border: 2px solid;
  border-color: transparent transparent #fff #fff;
  transform: rotate(-45deg);
  display: none;
}
.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark{
  background: #fec107;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark:before{
  display: block;
}

.wrapper .form .inputfield .btn{
  width: 100%;
   padding: 8px 10px;
  font-size: 15px; 
  border: 0px;
  background:  #fec107;
  color: #fff;
  cursor: pointer;
  border-radius: 3px;
  outline: none;
}

.wrapper .form .inputfield .btn:hover{
  background: #ffd658;
}

.wrapper .form .inputfield:last-child{
  margin-bottom: 0;
}

@media (max-width:420px) {
  .wrapper .form .inputfield{
    flex-direction: column;
    align-items: flex-start;
  }
  .wrapper .form .inputfield label{
    margin-bottom: 5px;
  }
  .wrapper .form .inputfield.terms{
    flex-direction: row;
  }
}
 body{        
        padding-top: 60px;
        padding-bottom: 40px;
    }
    .fixed-header {
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    
    .fixed-footer {
     width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    nav a{
        color: #fff;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }






    .navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
  width: 89px;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}


</style>
                  
</head>
<body>
<div class="fixed-header">
		<div class="navbar">
			<a href="Menu.jsp">Home</a> <a href="#news">About us</a>
			<div class="dropdown">
				<button class="dropbtn">
					Servies <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="Addstudent.jsp">Add Student</a>
					<a href="Showstudentdata.jsp">Show all Student</a>
					<a href="GetStudentCourseServlet">Show all Student Course</a>

				</div>
			</div>
			<a href="LogOutServlet">Logout</a>
		</div>
		
	</div>
	<button><a href="Showstudentdata.jsp">BACK</a></button>
	

	<div class="wrapper">
		<div class="title">
			Update Student Course
			<form action="EditStudentCourseServlet" method="post">
		</div>
		<div class="form">
		     <div class="inputfield">
				<label></label> <input type="hidden" class="input" 
				name="course_id" value='<c:out value="${StudentCourse.course_id}" />'>
			</div>
			<div class="inputfield">
				<label>Course Name</label> <input type="text" class="input"
					name="course_name" value='<c:out value="${StudentCourse.course_name}" />'>
			</div>
			<div class="inputfield">
				<label>course Mentor</label> <input type="text" class="input"
					name="course_mentor" value='<c:out value="${StudentCourse.course_mentor}" />'>
			</div>

			

			<div class="inputfield">
				<label>Course Duration</label> <input type="number" class="input" name="course_duration"
					value='<c:out value="${StudentCourse.course_duration}" />'>
			</div>
			<div class="inputfield">
				<label></label> <input type="hidden" class="input" name="sid"
					value='<c:out value="${StudentCourse.sid}" />'>
			</div>

			<div class="inputfield">
				<input type="submit" value="Update Student course" class="btn">
			</div>
		</div>
		</form>
	</div>


	<div class="fixed-footer">
		<div class="container">Copyright &copy; 2022 My School</div>
	</div>

</body>
</html>