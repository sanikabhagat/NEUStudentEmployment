<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Registration Successful
To validate your account please click on the link sent to your mail.

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

 <a href="${contextPath}login.htm">Return to Login Page</a>
</body>
</html>