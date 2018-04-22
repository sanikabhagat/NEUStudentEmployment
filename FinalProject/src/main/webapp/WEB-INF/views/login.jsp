
<jsp:include page="header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>

    <div class="mainbody" style="height:200px">
    
    </div>

	<div class="login">
	<form class="form-inline" action="login.htm" method="POST">
  <label class="sr-only" for="emailid"/>Email</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email ID" name="emailid" />
	
	<br/><br/>
	
	
  <label class="sr-only" for="password">Password</label>
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password"/>
   
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
</form>
	</div>
    <jsp:include page="footer.jsp" />