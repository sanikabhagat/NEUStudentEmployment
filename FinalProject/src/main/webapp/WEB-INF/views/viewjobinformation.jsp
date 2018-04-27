<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- <p>Edit Job</p> -->

    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	View Job Information
    </div>
	



<div class="container">
<form action="viewjobinformation.htm" method="POST">
<input type="hidden" id="jobid" name="jobid" value="${map.jobDesc.jobid}">
<p>Job ID : <c:out value = "${map.jobDesc.jobid}"/></p>
<p>Job Title : <c:out value = "${map.jobDesc.jobtitle}"/></p>
<p>Employer : <c:out value = "${map.jobDesc.employer}"/></p>
<p>Category : <c:out value = "${map.jobDesc.category}"/></p>
<p>Wage : <c:out value = "${map.jobDesc.wage}"/></p>
<p>Openings : <c:out value = "${map.jobDesc.openings}"/></p>

<%--  <a href="${contextPath}/user/editjob.htm">Job ID :<c:out value = "${map.jobToEdit.jobid}"/></a> --%>
<%--  <p>Job Title :<c:out value = "${map.jobToEdit.jobtitle}"/></p>
  <p>Employer :<c:out value = "${map.jobToEdit.employer}"/></p>
 <p>Openings :<c:out value = "${map.jobToEdit.openings}"/></p> --%>
 <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Apply</button>
</form>
</div>
        


<jsp:include page="footer.jsp" />