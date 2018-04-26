<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<ul>
<li><a href="${contextPath}/user/createjob.htm">Create New Job</a></li>
        <li><a href="${contextPath}/user/joblist.htm">Update Job</a></li>
            <li><a href="${contextPath}/user/joblist.htm">Delete Job</a></li>
              <li><a href="${contextPath}/user/viewallapplications.htm">View All Applications</a></li>
</ul>



<jsp:include page="footer.jsp" />
