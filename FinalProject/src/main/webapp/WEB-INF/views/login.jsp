
<jsp:include page="header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Login Page	
    </div>

	<div class="login">
	
	<form:form action="login.htm" method="POST" commandName="userForm">
	
  <form:label class="sr-only" for="emailid" path="emailid"/>Email
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email ID" name="emailid" path="emailid"/>
	<form:errors path="emailid" cssClass="error"/>
	<br/><br/>
	
	
  <form:label class="sr-only" for="password" path="password"/>Password
 
    <form:password class="form-control" id="password" placeholder="Enter Password" name="password" path="password"/>
   <form:errors path="password" cssClass="error"/>
  </div>
   
  <br/><br/>
 <%--  <form:label class="sr-only" for="emailid" path="emailid"/>Login As --%>
  <select name="role">
  <option value="Student">Student</option>
  <option value="Admin">Admin</option>
</select>
     
     
     
<br/><br/>



  <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none;">Log In</button>
</form:form>
	
    <jsp:include page="footer.jsp" />