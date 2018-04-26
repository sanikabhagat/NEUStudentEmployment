<jsp:include page="header.jsp" />



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<p>View Application status</p>

<c:set value="${map.applicationDesc}" var="application"/> 


<div class="container">
<!-- <form action="editjob.htm" method="POST"> -->
 <form> 
<p>Application ID : <c:out value = "${application.applicationid}"/></p>
 <p>Job Title :<c:out value = "${application.job.jobid}"/></p>
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>


  <button type="submit" class="btn btn-primary">Print Application</button>
</form> 
</div>



<jsp:include page="footer.jsp" />