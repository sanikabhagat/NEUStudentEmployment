<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

 <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Available Jobs List
    </div>

<c:forEach items="${map.listOfJobs}" var="job">


<form action="joblist.htm?jobid=${job.jobid}" method="POST">

   

<div class="container1">
 <p><a href="${contextPath}/user/editjob.htm?jobid=${job.jobid}">Job ID :<c:out value = "${job.jobid}"/></a></p>
 <p>Job Title :<c:out value = "${job.jobtitle}"/></p>
  <p>Employer :<c:out value = "${job.employer}"/></p>
 <p>Openings :<c:out value = "${job.openings}"/></p>
 <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Delete Job</button>

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