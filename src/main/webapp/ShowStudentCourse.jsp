<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showData</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Showstudentdata.css">
<style type="text/css">



 body{        
        padding-top: 60px;
        padding-bottom: 40px;
    }
    .fixed-header, .fixed-footer{
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
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 7px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
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

/*n*/
table { 
    width: 750px; 
    border-collapse: collapse; 
    margin:50px auto;
    }

/* Zebra striping */
tr:nth-of-type(odd) { 
    background: #eee; 
    }

th { 
    background: #3498db; 
    color: white; 
    font-weight: bold; 
    }

td, th { 
    padding: 10px; 
    border: 1px solid #ccc; 
    text-align: left; 
    font-size: 18px;
    }

/* 
Max width before this PARTICULAR table gets nasty
This query will take effect for any screen smaller than 760px
and also iPads specifically.
*/
@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

    table { 
        width: 100%; 
    }

    /* Force table to not be like tables anymore */
    table, thead, tbody, th, td, tr { 
        display: block; 
    }
    
    /* Hide table headers (but not display: none;, for accessibility) */
    thead tr { 
        position: absolute;
        top: -9999px;
        left: -9999px;
    }
    
    tr { border: 1px solid #ccc; }
    
    td { 
        /* Behave  like a "row" */
        border: none;
        border-bottom: 1px solid #eee; 
        position: relative;
        padding-left: 50%; 
    }

    td:before { 
        /* Now like a table header */
        position: absolute;
        /* Top/left values mimic padding */
        top: 6px;
        left: 6px;
        width: 45%; 
        padding-right: 10px; 
        white-space: nowrap;
        /* Label the data */
        content: attr(data-column);

        color: #000;
        font-weight: bold;
    }

}
</style>
</head>
<body>
 
                    <div class="fixed-header">
                         <div class="navbar">
                             <a href="Menu.jsp">Home</a>
                             <a href="#news">About us</a>
                               <div class="dropdown">
                                 <button class="dropbtn">Servies 
                                 <i class="fa fa-caret-down"></i>
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
                    <button><a href="Addstudent.jsp">BACK</a></button>
                   
    <div class="container">
        <p style="text-align: center;"><b>Show All Student Course</b></p>
    </div>
     <table>
  <thead>
     <tr>
            <th>CourseId</th>
            <th>CourseName</th>
            <th>CourseMentor</th>
            <th>CourseDuration</th>
            <th>StudentsId</th>
            <th>Edit</th>
            <th>Delete</th>
           
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${studentcourseList}" var="entry">
         
        <tr>
          <td><c:out value="${entry.value.course_id}" /></td>
          <td><c:out value="${entry.value.course_name}" /></td>
          <td><c:out value="${entry.value.course_mentor}" /></td>
          <td><c:out value="${entry.value.course_duration}" /></td>
          <td><c:out value="${entry.value.sid}" /></td>
         
          <td><a href="EditStudentCourseServlet?course_id=<c:out value='${entry.value.course_id}' />">Edit</a></td>
          <td><a href="DeleteStudentCourseServlet?course_id=<c:out value="${entry.value.course_id}" />">Delete</a></td>

        </tr>
      </c:forEach>
      

  </tbody>
</table>

    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2022 My School</div>        
    </div>
	
</body>
</html>