<jsp:include page="header.jsp" />



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Change Application Status
    </div>

<!-- <p>Change Application status</p>


Chhhhhhhhhhhhhhhhhhhhhhhhhhhangeeeeeeeeeeeeeeeeeeeeeee -->

<c:set value="${map.eachApplicationStatusChange}" var="application"/> 


<div class="container">
 <form action="editstatus.htm" method="POST"> 
<!--  <form>  -->

<input type="hidden" name="applicationid" id="applicationid" value="${application.applicationid}">
<p>Application ID : <c:out value = "${application.applicationid}"/></p>
 <p>Job Title :<c:out value = "${application.job.jobid}"/></p>
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>
<p>Change Application status :
<select name="appstatus">
  <option value="accept">Accept</option>
  <option value="reject">Reject</option>
</select></p>

  <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Change and Save Status</button>
</form> 
</div>



<jsp:include page="footer.jsp" />