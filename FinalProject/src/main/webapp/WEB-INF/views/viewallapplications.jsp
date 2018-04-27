<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	All Applications List
    </div>


<c:forEach items="${map.allApplications}" var="application">

<!-- <form action="viewjobinformation.htm" method="POST"> --> 
 <form action="changeapplicationstatus.htm" method="POST"> 
<div class="container1">
<input type="hidden" id="jobid" name="jobid" value="${applicat.jobid}"/> 
<input type="hidden" id="applicationid" name="applicationid" value="${application.applicationid}"/> 
<p><a href="${contextPath}/user/printapplication.htm?applicationid=${application.applicationid}">Application ID :<c:out value = "${application.applicationid}"/></a></p> 
 
 
  <p>Job ID :<c:out value = "${application.job.jobid}"/></p> 
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>
<p><a href="${contextPath}/user/resume.pdf?applicationid=${application.applicationid}">View Resume</a></p>



  <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Change Application status</button>

</div>
        
  </form>      
         </c:forEach>
         
         <style>
         .container1{
 border:1px solid #cccccc;
 border-radius:10px;
 font-size:16px;
 padding:10px 0px 10px 30px;
 width:400px;
 margin-bottom:30px;
}
         </style>


<jsp:include page="footer.jsp" />