<jsp:include page="header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

    <div class="mainbody" style="text-align:center;font-size:24px;margin-bottom:20px;">
    	Admin Dashboard
    </div>




<div class="container" style="text-align:center">



<ul class="dash" style="list-style-type:none;padding:0px">
<li><a href="${contextPath}/user/createjob.htm">Create New Job</a></li>
        <li><a href="${contextPath}/user/joblist.htm">Update Job</a></li>
            <li><a href="${contextPath}/user/joblist.htm">Delete Job</a></li>
              <li><a href="${contextPath}/user/viewallapplications.htm">View All Applications</a></li>
</ul>


</div>

<style>
.dash li{
font-size:16px;
margin-bottom:20px;
}

.container{
padding:0px;}
</style>

<jsp:include page="footer.jsp" />
