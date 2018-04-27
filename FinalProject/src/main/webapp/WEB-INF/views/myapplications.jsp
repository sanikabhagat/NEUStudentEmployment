<jsp:include page="header.jsp" />



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<%-- <c:set value="${map.listOfApplications.jobid}" var="job"/> --%>

   <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	View My Applications
    </div>


<c:forEach items="${map.listOfApplications}" var="application">

 
 <form action="checkapplicationstatus.htm" method="POST"> 
<!-- <form> -->
<div class="container1">
<p> <a href="${contextPath}/user/printapplication.htm?applicationid=${application.applicationid}">Application ID :<c:out value = "${application.applicationid}"/></a></p> 
 
 <input type="hidden" name="applicationid" id="applicationid" value="${application.applicationid}">
 
  <p>Job ID :<c:out value = "${application.job.jobid}"/></p> 
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>
   
 <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Check Application Status</button> 

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