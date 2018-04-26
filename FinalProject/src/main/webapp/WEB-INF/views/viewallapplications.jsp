<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<c:forEach items="${map.allApplications}" var="application">

<!-- <form action="viewjobinformation.htm" method="POST"> --> 
 <form action="changeapplicationstatus.htm" method="POST"> 
<div class="container" style="border:1px solid black">
<input type="hidden" id="jobid" name="jobid" value="${applicat.jobid}"/> 
<input type="hidden" id="applicationid" name="applicationid" value="${application.applicationid}"/> 
<a href="${contextPath}/user/printapplication.htm?applicationid=${application.applicationid}">Application ID :<c:out value = "${application.applicationid}"/></a> 
 
 
  <p>Job ID :<c:out value = "${application.job.jobid}"/></p> 
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>




  <button type="submit">Change Application status</button>

</div>
        
  </form>      
         </c:forEach>


<jsp:include page="footer.jsp" />