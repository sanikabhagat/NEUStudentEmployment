<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Edit Job
    </div>



<div class="container11">
<form class="form-inline" action="editjob.htm" method="POST">
<!-- 
  <form:label class="sr-only" for="firstname" path="firstname"/>First Name
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname" placeholder="Enter First Name" name="firstname" path="firstname"/>
	<form:errors path="firstname" cssClass="error"/>
	<br/><br/> -->

<p>Job ID</p>

<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="jobid" name="jobid" value="<c:out value = "${map.jobToEdit.jobid}"/>"> 
<p>Job Title</p>
<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="jobtitle" name="jobtitle" value="<c:out value = "${map.jobToEdit.jobtitle}"/>">
<p>Employer</p>
<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="employer" name="employer" value="<c:out value = "${map.jobToEdit.employer}"/>">
<p>Category</p>
<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="category" name="category" value="<c:out value = "${map.jobToEdit.category}"/>">
<p>Wage</p>
<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="wage" name="wage" value="<c:out value = "${map.jobToEdit.wage}"/>">
<p>Openings</p>
<input class="form-control mb-2 mr-sm-2 mb-sm-0" type="text" id="openings" name="openings" value="<c:out value = "${map.jobToEdit.openings}"/>">
<br/><br/>
<%--  <a href="${contextPath}/user/editjob.htm">Job ID :<c:out value = "${map.jobToEdit.jobid}"/></a> --%>
<%--  <p>Job Title :<c:out value = "${map.jobToEdit.jobtitle}"/></p>
  <p>Employer :<c:out value = "${map.jobToEdit.employer}"/></p>
 <p>Openings :<c:out value = "${map.jobToEdit.openings}"/></p> --%>
 <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Edit And Save</button>
</form>
</div>
        
<style>

.container11 p{
margin-bottom:0px;
}


.container11 input{
margin-bottom:20px;
}

.jobtoed{
padding-bottom:20px;
color: #cccccc;
}
</style>

<jsp:include page="footer.jsp" />