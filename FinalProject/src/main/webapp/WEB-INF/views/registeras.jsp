<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container" style="text-align:center">
<ul class="ra" style="list-style-type:none">
<li><a href="${contextPath}/user/adminregister.htm">Register As Admin</a></li>
        <li><a href="${contextPath}/user/studentregister.htm">Register As Student</a></li>
            
</ul>

</div>
<style>
.ra li{
font-size:16px;
margin-bottom:20px;
}
</style>

<jsp:include page="footer.jsp" />