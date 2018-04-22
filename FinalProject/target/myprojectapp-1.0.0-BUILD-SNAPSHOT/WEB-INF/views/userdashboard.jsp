<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<ul>
<li><a href="${contextPath}/user/myapplications.htm">My Applications</a></li>
        <li><a href="${contextPath}/user/mydetails.htm">My Details</a></li>
            <li><a href="${contextPath}/user/viewalljobs.htm">View All Jobs</a></li>
</ul>



<jsp:include page="footer.jsp" />
