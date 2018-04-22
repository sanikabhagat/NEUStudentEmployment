<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ul>
<li><a href="${contextPath}/user/adminregister.htm">Register As Admin</a></li>
        <li><a href="${contextPath}/user/studentregister.htm">Register As Student</a></li>
            
</ul>


<jsp:include page="footer.jsp" />