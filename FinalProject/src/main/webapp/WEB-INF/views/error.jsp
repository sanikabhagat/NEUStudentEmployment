<jsp:include page="header.jsp" />


<p>
Invalid Username/PAssword
<p>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

 <a href="${contextPath}login.htm">Return to Login Page</a>

<jsp:include page="footer.jsp" />