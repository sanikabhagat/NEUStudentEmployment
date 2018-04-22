<jsp:include page="header.jsp" />



<p>Apply To Job</p>


Hi, ${sessionScope.user.firstname}
${sessionScope.user.emailid}
 <%-- <input type="hidden" value="${sessionScope.user.emailid}" name="loggedadmin"> 
  --%>


	<div class="applyjob">
	<form class="form-inline" action="applyjob.htm" method="POST">
	
	
  <label class="sr-only" for="firstname">First Name</label>
  ${sessionScope.user.firstname}
   <input type="hidden" class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname" name="firstname" value="${sessionScope.user.firstname}"/>
	
	<br/><br/>
	
	
  <label class="sr-only" for="lastname">Last Name</label>
  ${sessionScope.user.lastname}
   <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="lastname" name="lastname" value="${sessionScope.user.lastname}"/>
   
  </div> 
   
  <br/><br/>
  
  
   <label class="sr-only" for="emailid">Email</label>
   ${sessionScope.user.emailid}
   <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="emailid" name="emailid" value="${sessionScope.user.emailid}"/>
   
  </div>
   
  <br/><br/>
  
  
     <label class="sr-only" for="nuid">NUID</label>
     ${sessionScope.user.nuid}
     
   <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="nuid" name="nuid" value="${sessionScope.user.nuid}"/>
   
  </div> 
   
  <br/><br/>
  
       <label class="sr-only" for="grade">What is your current grade level?</label>
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="grade" placeholder="Enter Grade" name="grade"/>
   
  </div>
   
  <br/><br/>
  
  
         <label class="sr-only" for="experience">List any work experience you have</label>
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="experience" placeholder="Enter Experience" name="experience"/>
   
  </div>
   
  <br/><br/>
  
  
         <label class="sr-only" for="grade">List any Skills, Degrees or Certifications you have</label>
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="text" class="form-control" id="skills" placeholder="Enter Skills" name="skills"/>
   
  </div>
   
  <br/><br/>
  
 <!--           <label class="sr-only" for="resume">Upload your Resume</label>
  <div class="input-group mb-2 mr-sm-2 mb-sm-0">
    <input type="hidden" class="form-control" id="resume" placeholder="Enter Password" name="resume"/>
   
  </div> -->
   
  <br/><br/>
  


  <button type="submit" class="btn btn-primary">Submit Application</button>
</form>
	</div>


<jsp:include page="footer.jsp" />