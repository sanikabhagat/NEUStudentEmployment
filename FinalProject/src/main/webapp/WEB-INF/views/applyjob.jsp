<jsp:include page="header.jsp" />



<p>Apply To Job</p>


Hi, ${sessionScope.user.firstname} Hi : ${map.jobDesc} Hi :
${map.jobDesc.jobid} ${sessionScope.user.emailid}
<%-- <input type="hidden" value="${sessionScope.user.emailid}" name="loggedadmin"> 
  --%>



<div class="applyjob">
	<form class="form-inline" action="applyjob.htm" method="POST">

		<input type="hidden" value="${map.jobDesc.jobid}" name="jobid">

		<label class="sr-only" for="firstname">First Name</label>
		${sessionScope.user.firstname} <input type="hidden"
			class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname"
			name="firstname" value="${sessionScope.user.firstname}" /> <br /> <br />
		<label class="sr-only" for="lastname">Last Name</label>
		${sessionScope.user.lastname}
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="hidden" class="form-control" id="lastname"
				name="lastname" value="${sessionScope.user.lastname}" />

		</div>

		<br /> <br /> <label class="sr-only" for="emailid">Email</label>
		${sessionScope.user.emailid}
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="hidden" class="form-control" id="emailid" name="emailid"
				value="${sessionScope.user.emailid}" />

		</div>

		<br /> <br /> <label class="sr-only" for="nuid">NUID</label>
		${sessionScope.user.nuid}

		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="hidden" class="form-control" id="nuid" name="nuid"
				value="${sessionScope.user.nuid}" />

		</div>

		<br /> <br /> <label class="sr-only" for="grade">What is
			your current grade level?</label>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="text" class="form-control" id="grade"
				placeholder="Enter Grade" name="grade" />

		</div>

		<br /> <br /> <label class="sr-only" for="experience">List
			any work experience you have</label>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="text" class="form-control" id="experience"
				placeholder="Enter Experience" name="experience" />

		</div>

		<br /> <br /> <label class="sr-only" for="grade">List any
			Skills, Degrees or Certifications you have</label>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="text" class="form-control" id="skills"
				placeholder="Enter Skills" name="skills" />

		</div>

		<br /> <br /> <br /> <br />



		<button type="submit" class="btn btn-primary">Submit
			Application</button>
	</form>

	<form method="POST" id="fileUploadForm" action="/upload"
		enctype="multipart/form-data">

		<label class="sr-only" for="resume">Upload your Resume</label>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="file" name="file" id="file"> <input
				type="submit" value="Upload" name="uploadbtn" id="uploadbtn">
		</div>
	</form>
</div>

<script>
	$(document).ready(function() {

		$("#uploadbtn").click(function(event) {

			//stop submit the form, we will post it manually.
			event.preventDefault();

			fire_ajax_submit();

		});

	});

	function fire_ajax_submit() {

		// Get form
		var form = $('#fileUploadForm')[0];

		var data = new FormData(form);

		// data.append("CustomField", "This is some extra data, testing");

		$("#uploadbtn").prop("disabled", true);

		$.ajax({
			type : "POST",
			enctype : 'multipart/form-data',
			url : "upload.htm",
			data : data,
			//http://api.jquery.com/jQuery.ajax/
			//https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
			processData : false, //prevent jQuery from automatically transforming the data into a query string
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(data) {

				$("#result").text(data);
				console.log("SUCCESS : ", data);
				$("#uploadbtn").prop("disabled", false);

			},
			error : function(e) {

				$("#result").text(e.responseText);
				console.log("ERROR : ", e);
				$("#uploadbtn").prop("disabled", false);

			}
		});

	}
</script>


<jsp:include page="footer.jsp" />