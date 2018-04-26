<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<input type="hidden" id="contextPath"
	value="${pageContext.request.contextPath}" name="contextPath">
<input type="text" name="searchjob" id="searchjob" />
<!-- <button onclick="searchjob()">Search</button> -->

<div class="main_container" name="main_container" id="main_container"></div>

<script>
	
$( document ).ready(function() {
	searchjob();
});


$( "#searchjob" ).keyup(function() {
	  searchjob();
	});


	function searchjob() {

			
		var main_container = document.getElementById("main_container");
		main_container.innerHTML="";
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

				for (job in data) {

					var div_container = document.createElement("div");

					var input = document.createElement("input");
					input.type = "hidden";
					input.id = "jobid";
					input.name = "jobid";
					input.value = data[job].jobid;

					var a = document.createElement("a");
							a.href = contextPath
									+ "/user/viewjobinformation.htm?jobid="
									+ data[job].jobid;
									a.innerHTML = "Job ID";
					a.value = data[job].jobid;

					var p_jobtitle = document.createElement("p");
					p_jobtitle.innerHTML = "Job Title: " + data[job].jobtitle;

					var p_employer = document.createElement("p");
					p_employer.innerHTML = "Employer: " + data[job].employer;

					var p_openings = document.createElement("p");
					p_openings.innerHTML = "Openings: " + data[job].openings;

					var button = document.createElement("button");
					button.type = "submit";
					button.innerHTML = "Apply";

					div_container.appendChild(input);
					div_container.appendChild(a);
					div_container.appendChild(p_jobtitle);
					div_container.appendChild(p_employer);
					div_container.appendChild(p_openings);
					div_container.appendChild(button);

					main_container.appendChild(div_container);

				}

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