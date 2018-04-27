
<jsp:include page="header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" /> 

<%-- Admin ID :${sessionScope.user.emailid}
 --%>
    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    Create New Job
    </div>
	
	<div class="createjob">
	<form class="form-inline" action="createjob.htm" method="POST">
	
	 <label for="jobid">Job ID</label><br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="jobid" placeholder="Enter Job ID" name="jobid" />
	
	<br/><br/>
	
  <label for="jobtitle">Job Title</label><br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="jobtitle" placeholder="Enter Job Title" name="jobtitle" />
	
	<br/><br/>
	
		 <label for="employer">Employer</label><br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="employer" placeholder="Enter Employer" name="employer" />
	
	<br/><br/>
	
	<label for="category">Category</label><br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="category" placeholder="Enter Category" name="category" />
	
	<br/><br/>
	
  <label for="wage">Wage</label>
  <br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="wage" placeholder="Enter Wage" name="wage" />
	
	<br/><br/>
	
	
 <label for="openings">Number Of Openings</label>
 <br/>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="openings" placeholder="Enter Number of Openings" name="openings" />
	
	
	 <input type="hidden" value="${sessionScope.user.emailid}" name="loggedadmin"> 
     
<br/><br/>



  <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Create Job</button>
</form>
	</div>
	
	<style>
	label{
	font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
	font-size:16px;
	font-weight:100;
	}
	

	</style>
	
	
    <jsp:include page="footer.jsp" />