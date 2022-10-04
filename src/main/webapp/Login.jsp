<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title> Login  </title>
  <link rel="stylesheet" href="loginNew.css">

</head>
<body>

	<h1 style="text-align: center;">Login</h1>
	<p style="text-align: center;" class="sub"><b>Only Admin and Staff can
		access to login</b></p>
	<p style="text-align: center;">
		<c:out value="${error}" />
	</p>
	<p class="error" style="text-align: center;">
		<c:out value="${loginError}"></c:out>
	</p>
	<p class="error" style="text-align: center;">
		<c:out value="${logOutError}"></c:out>
	</p>
	
	<div class="login-page">
  <div class="form">
     <form class="login-form"  action="LoginServlet" method="Post">
      <input type="text" placeholder="Username" name="username"/>
      <input type="password" placeholder="Password" name="password"/>
      <button>login</button>
     </form>
  </div>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="loginjs.js"></script>

</body>
</html>