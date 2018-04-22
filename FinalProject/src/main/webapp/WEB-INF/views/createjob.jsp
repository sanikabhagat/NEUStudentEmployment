
<jsp:include page="header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" /> 

Admin ID :${sessionScope.user.emailid}

    <div class="mainbody" style="height:200px">
    
    </div>

	<div class="createjob">
	<form class="form-inline" action="createjob.htm" method="POST">
	
	 <label class="sr-only" for="jobid">Job ID</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="jobid" placeholder="Enter Job ID" name="jobid" />
	
	<br/><br/>
	
  <label class="sr-only" for="jobtitle">Job Title</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="jobtitle" placeholder="Enter Job Title" name="jobtitle" />
	
	<br/><br/>
	
		 <label class="sr-only" for="employer">Employer</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="employer" placeholder="Enter Employer" name="employer" />
	
	<br/><br/>
	
	<label class="sr-only" for="category">Category</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="category" placeholder="Enter Category" name="category" />
	
	<br/><br/>
	
  <label class="sr-only" for="wage">Wage</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="wage" placeholder="Enter Wage" name="wage" />
	
	<br/><br/>
	
	
 <label class="sr-only" for="openings">Number Of Openings</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="openings" placeholder="Enter Number of Openings" name="openings" />
	
	
	 <input type="hidden" value="${sessionScope.user.emailid}" name="loggedadmin"> 
     
<br/><br/>



  <button type="submit" class="btn btn-primary">Create Job</button>
</form>
	</div>
    <jsp:include page="footer.jsp" />