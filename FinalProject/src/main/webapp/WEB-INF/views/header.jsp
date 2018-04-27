<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   
   <c:set var="admin" value="admin" />
   
      <c:set var="student" value="student" />
   
   
   
   <div class="container">
    <div class="brand">
    Northeastern University : ${contextPath}
    </div>
    <div class="navbar">
    
    
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
      <c:choose>   
<c:when test="${sessionScope.user.role eq student}">


 <li class="active"><a href="${contextPath}/user/userdashboard.htm">Student</a></li>
		
        </c:when>
        
        
        <c:when test="${sessionScope.user.role eq admin}">


  <li><a href="${contextPath}/user/admindashboard.htm">Admin</a></li>
		
        </c:when>
        
        <c:otherwise>
       
        </c:otherwise>
      </c:choose>  
      
      
      <!--   <li class="active"><a href="#">Student <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Admin</a></li> -->
         <li><a href="#">Help</a></li>
         </ul>
      <ul class="nav navbar-nav navbar-right">
      
   <c:choose>   
<c:when test="${sessionScope.user != null}">

		<li><a href="${contextPath}/user/userdashboard.htm">Hi, ${sessionScope.user.firstname}</a></li>
        <li><a href="${contextPath}/user/logout.htm">Logout</a></li>
     
        </c:when>
        
        <c:otherwise>
         <li><a href="${contextPath}/user/registeras.htm">Register</a></li>
        <li><a href="${contextPath}/user/login.htm">Login</a></li>
        </c:otherwise>
      </c:choose>   
        	
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    </div>
    