
<jsp:include page="header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <div class="mainbody" style="height:200px">
    
    </div>

	<div class="login">
	<form:form class="form-inline" action="login.htm" method="POST" commandName="userForm">
  <form:label class="sr-only" for="emailid" path="emailid"/>Email
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email ID" name="emailid" path="emailid"/>
	<form:errors path="emailid" cssClass="error"/>
	<br/><br/>
	
	
  <form:label class="sr-only" for="password" path="password"/>Password
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <form:password class="form-control" id="password" placeholder="Enter Password" name="password" path="password"/>
   <form:errors path="password" cssClass="error"/>
  </div>
   
  <br/><br/>
  
  <select name="role">
  <option value="Student">Student</option>
  <option value="Admin">Admin</option>
</select>
     
<br/><br/>

  <div class="form-check mb-2 mr-sm-2 mb-sm-0">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>

  <button type="submit" class="btn btn-primary">Log In</button>
</form:form>
	</div>
    <jsp:include page="footer.jsp" />