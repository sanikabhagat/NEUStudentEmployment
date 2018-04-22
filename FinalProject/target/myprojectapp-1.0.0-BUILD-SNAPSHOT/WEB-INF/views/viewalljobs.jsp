<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<c:forEach items="${map.listOfJobs}" var="job">

<form action="viewjobinformation.htm?jobid=${job.jobid}" method="POST">
<div class="container">
 <a href="${contextPath}/user/viewjobinformation.htm?jobid=${job.jobid}">Job ID :<c:out value = "${job.jobid}"/></a>
 <p>Job Title :<c:out value = "${job.jobtitle}"/></p>
  <p>Employer :<c:out value = "${job.employer}"/></p>
 <p>Openings :<c:out value = "${job.openings}"/></p>
 <button type="submit">Apply</button>

</div>
        
  </form>       
         </c:forEach>


<jsp:include page="footer.jsp" />