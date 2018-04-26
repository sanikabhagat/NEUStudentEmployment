<jsp:include page="header.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
    <div class="mainbody" style="height:200px">
    
    </div>

	<div class="register">
	<form method="POST" action="adminregister.htm">
	
  <label class="sr-only" for="firstname">First Name</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname" placeholder="Enter First Name" name="firstname"/>
	
	<br/><br/>
	
<label class="sr-only" for="lastname">Last Name</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="lastname" placeholder="Enter Last Name" name="lastname"/>

<br/><br/>

<label class="sr-only" for="employeeid">Employee ID</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="employeeid" placeholder="Enter Employee ID" name="employeeid"/>

<br/><br/>

<label class="sr-only" for="password">Password</label>
  <input type="password" class="form-control mb-2 mr-sm-2 mb-sm-0" id="password" placeholder="Enter Password" name="password"/>

<br/><br/>

<label class="sr-only" for="emailid">Email ID</label>
  <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email" name="emailid"/>

<br/><br/>


  
   <label for="captchaCode" class="prompt">Retype the characters from the picture:</label> 
				<%
				// Adding BotDetect Captcha to the page
					Captcha captcha = Captcha.load(request, "CaptchaObject");
					captcha.setUserInputID("captchaCode");

					String captchaHtml = captcha.getHtml();
					out.write(captchaHtml);
				%> 
				<input id="captchaCode" type="text" name="captchaCode" required="required"/> 

  <button type="submit" class="btn btn-primary">Sign Up</button>
</form>
	</div>

    <jsp:include page="footer.jsp" />