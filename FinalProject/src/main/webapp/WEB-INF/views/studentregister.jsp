<jsp:include page="header.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
    <div class="mainbody" style="height:200px">
    
    </div>

	<div class="register">
	<form:form method="POST" action="studentregister.htm" commandName="loginStudentForm">
	
  <form:label class="sr-only" for="firstname" path="firstname"/>First Name
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname" placeholder="Enter First Name" name="firstname" path="firstname"/>
	<form:errors path="firstname" cssClass="error"/>
	<br/><br/>
	
<form:label class="sr-only" for="lastname" path="lastname"/>Last Name
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="lastname" placeholder="Enter Last Name" name="lastname" path="lastname"/>
	<form:errors path="lastname" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="nuid" path="nuid"/>NUID
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="nuid" placeholder="Enter NUID" name="nuid" path="nuid"/>
	<form:errors path="nuid" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="password" path="password"/>Password
  <form:password class="form-control mb-2 mr-sm-2 mb-sm-0" id="password" placeholder="Enter Password" name="password" path="password"/>
<form:errors path="password" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="emailid" path="emailid"/>Email ID
  <form:input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email" name="emailid" path="emailid"/>
<form:errors path="emailid" cssClass="error"/>
<br/><br/>

  <form:label class="sr-only" for="program" path="program"/>Program
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="program" placeholder="Enter Program" name="program" path="program"/>
  <form:errors path="program" cssClass="error"/>
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
</form:form>
	</div>

    <jsp:include page="footer.jsp" />