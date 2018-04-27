<jsp:include page="header.jsp" />

 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


   <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Registration Successful
    </div>

<div class="logindiv">
 
 <a href="${contextPath}login.htm">Return to Login Page</a>
 
</div>


<style>
.logindiv{
font-size:16px;
margin-bottom:20px;
text-align:center;
}
</style>

<jsp:include page="footer.jsp" />