<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

${sessionScope.user.userid} 

<%-- ${sessionScope.student.studentid} --%>



<ul>
    <li><a href="${contextPath}/user/viewalljobs.htm">View All Jobs</a></li>
        <li><a href="${contextPath}/user/viewalljobs.htm">Apply to Jobs</a></li>
<li><a href="${contextPath}/user/myapplications.htm?userid=${sessionScope.user.userid}">My Applications</a></li>
        <li><a href="${contextPath}/user/mydetails.htm">View Application Status</a></li>
        
</ul>



<jsp:include page="footer.jsp" />
