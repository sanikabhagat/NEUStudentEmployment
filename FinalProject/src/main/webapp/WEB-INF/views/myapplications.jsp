<jsp:include page="header.jsp" />



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<%-- <c:set value="${map.listOfApplications.jobid}" var="job"/> --%>


<c:forEach items="${map.listOfApplications}" var="application">

<%-- <form action="joblist.htm?jobid=${job.jobid}" method="POST"> --%>
<form>
<div class="container" style="border:1px solid black">
 <a href="${contextPath}/user/printapplication.htm?jobid=${application.job.jobid}">Job ID :<c:out value = "${application.job.jobid}"/></a> 
 <%-- 
 
  <p>Job ID :<c:out value = "${application.job.jobid}"/></p> --%>
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>
   
<!--  <button type="submit">Delete Job</button> -->

</div>
        
  </form>       
         </c:forEach>


<jsp:include page="footer.jsp" />