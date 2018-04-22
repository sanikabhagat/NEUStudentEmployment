<jsp:include page="header.jsp" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<p>Edit Job</p>




<div class="container">
<form action="editjob.htm" method="POST">
<p>Job ID<input type="text" id="jobid" name="jobid" value="<c:out value = "${map.jobToEdit.jobid}"/>"></p>
<p>Job Title<input type="text" id="jobtitle" name="jobtitle" value="<c:out value = "${map.jobToEdit.jobtitle}"/>"></p>
<p>Employer<input type="text" id="employer" name="employer" value="<c:out value = "${map.jobToEdit.employer}"/>"></p>
<p>Category<input type="text" id="category" name="category" value="<c:out value = "${map.jobToEdit.category}"/>"></p>
<p>Wage<input type="text" id="wage" name="wage" value="<c:out value = "${map.jobToEdit.wage}"/>"></p>
<p>Openings<input type="text" id="openings" name="openings" value="<c:out value = "${map.jobToEdit.openings}"/>"></p>

<%--  <a href="${contextPath}/user/editjob.htm">Job ID :<c:out value = "${map.jobToEdit.jobid}"/></a> --%>
<%--  <p>Job Title :<c:out value = "${map.jobToEdit.jobtitle}"/></p>
  <p>Employer :<c:out value = "${map.jobToEdit.employer}"/></p>
 <p>Openings :<c:out value = "${map.jobToEdit.openings}"/></p> --%>
 <button type="submit" class="btn btn-primary">Edit And Save</button>
</form>
</div>
        


<jsp:include page="footer.jsp" />