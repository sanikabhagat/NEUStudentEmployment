<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%-- ${sessionScope.user.userid}  --%>

<%-- ${sessionScope.student.studentid} --%>
    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	User Dashboard
    </div>


<div class="container" style="text-align:center;padding:0px">

<ul class="dash" style="list-style-type:none;padding:0px;">
    <li><a href="${contextPath}/user/viewalljobs.htm">View All Jobs</a></li>
        <li><a href="${contextPath}/user/viewalljobs.htm">Apply to Jobs</a></li>
<li><a href="${contextPath}/user/myapplications.htm?userid=${sessionScope.user.userid}">My Applications</a></li>
   
        
</ul>

</div>

<style>
.dash li{
font-size:16px;
margin-bottom:20px;
}
</style>

<jsp:include page="footer.jsp" />
