<jsp:include page="header.jsp" />



<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<input type="hidden" id="contextPath"
	value="${pageContext.request.contextPath}" name="contextPath">

<p>View Application status</p>

<c:set value="${map.applicationDesc}" var="application"/> 


<div class="container">
<!-- <form action="editjob.htm" method="POST"> -->
 <!-- <form action="printform.htm" method="POST">  -->
 
 <input type="hidden" name="applicationid" id="applicationid" value="${application.applicationid}"> 
<p>Application ID : <c:out value = "${application.applicationid}"/></p>
 <p>Job Title :<c:out value = "${application.job.jobid}"/></p>
   <p>Job Title :<c:out value = "${application.job.jobtitle}"/></p>
   <p>Employer :<c:out value = "${application.job.employer}"/></p>
   <p>Wage :<c:out value = "${application.job.wage}"/></p> 
 <p>Grade Level :<c:out value = "${application.skills}"/></p>
  <p>Skills :<c:out value = "${application.grade}"/></p>
   <p>Experience :<c:out value = "${application.experience}"/></p>


  <button type="submit" class="btn btn-primary" onclick="printform()">Print Application</button>
  
  <h3><a href="printform.pdf?applicationid=${application.applicationid}">Download PDF Document</a></h3>
<!-- </form>  -->
</div>

<script>

function printform(){
	
	//var main_container = document.getElementById("main_container");
	//main_container.innerHTML="";
	var contextPath = document.getElementById("contextPath").value;
	$.ajax({
		type : "POST",
		contentType : "application/x-www-form-urlencoded",
		url : contextPath + "/user/printform.htm",

		data : {
			applicationid : document.getElementById("applicationid").value
		},
		/* dataType : 'json', */
		timeout : 100000,
		success : function(data) {
			
		}

			
	});
	
	
}

</script>



<jsp:include page="footer.jsp" />