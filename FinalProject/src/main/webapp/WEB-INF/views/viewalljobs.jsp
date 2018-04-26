<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<input type="hidden" id="contextPath"
	value="${pageContext.request.contextPath}" name="contextPath">
<input type="text" name="searchjob" id="searchjob" />
<button onclick="searchjob()">Search</button>




<%-- <c:forEach items="${map.listOfJobs}" var="job">

	<form action="viewjobinformation.htm" method="POST">
		<!-- <form action="viewalljobs.htm" method="POST"> - -->

		<div class="container">

			<input type="hidden" value="${pageContext.request.contextPath}"
				name="contextPath"> <input type="text" name="searchjob"
				id="searchjob" />
			<button onclick="searchjob()">Search</button>


			<input type="hidden" id="jobid" name="jobid" value="${job.jobid}" />
			<a
				href="${contextPath}/user/viewjobinformation.htm?jobid=${job.jobid}">Job
				ID :<c:out value="${job.jobid}" />
			</a>
			<p>
				Job Title :
				<c:out value="${job.jobtitle}" />
			</p>
			<p>
				Employer :
				<c:out value="${job.employer}" />
			</p>
			<p>
				Openings :
				<c:out value="${job.openings}" />
			</p>
			<button type="submit">Apply</button>

		</div>
	</form>
</c:forEach>
 --%>


<script>
	function searchjob() {

		var contextPath = document.getElementById("contextPath").value;
		$.ajax({
			type : "POST",
			contentType : "application/x-www-form-urlencoded",
			url : contextPath + "/user/searchjob.htm",
			data : {
				searchjob : document.getElementById("searchjob").value
			},
			/* dataType : 'json', */
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);

			},
			error : function(e) {
				console.log("ERROR: ", e);

			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
</script>


<jsp:include page="footer.jsp" />