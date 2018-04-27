<jsp:include page="header.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Admin Register Page
    </div>

	<div class="register">
	<form:form method="POST" action="adminregister.htm" commandName="loginAdminForm">
	
  <form:label class="sr-only" for="firstname" path="firstname"/>First Name
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="firstname" placeholder="Enter First Name" name="firstname" path="firstname"/>
	<form:errors path="firstname" cssClass="error"/>
	<br/><br/>
	
<form:label class="sr-only" for="lastname" path="lastname"/>Last Name
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="lastname" placeholder="Enter Last Name" name="lastname" path="lastname"/>
<form:errors path="lastname" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="employeeid" path="employeeid"/>Employee ID
  <form:input class="form-control mb-2 mr-sm-2 mb-sm-0" id="employeeid" placeholder="Enter Employee ID" name="employeeid" path="employeeid"/>
<form:errors path="employeeid" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="password" path="password"/>Password
  <form:password class="form-control mb-2 mr-sm-2 mb-sm-0" id="password" placeholder="Enter Password" name="password" path="password"/>
<form:errors path="password" cssClass="error"/>
<br/><br/>

<form:label class="sr-only" for="emailid" path="emailid"/>Email ID
  <form:input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="emailid" placeholder="Enter Email" name="emailid" path="emailid"/>
<form:errors path="emailid" cssClass="error"/>
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
				
				<br/><br/>

  <button type="submit" class="btn btn-primary" style="background-color:#a30f2d;margin-top:20px;border:none">Sign Up</button>
</form:form>
	</div>
	
	<style>
	/* label{
	margin-bottom:20px;
	} */
	</style>

    <jsp:include page="footer.jsp" />