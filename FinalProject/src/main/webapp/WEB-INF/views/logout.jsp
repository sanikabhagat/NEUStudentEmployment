<jsp:include page="header.jsp" />


<p>
You have successfully Logged out
<p>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

 <a href="${contextPath}login.htm">Return to Login Page</a>

<jsp:include page="footer.jsp" />
