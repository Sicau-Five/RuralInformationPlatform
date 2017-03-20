<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test jstl</title>
<style type="text/css">
</style>
</head>
<body>
	<form action="demo.do" method="get">
		<input type="submit" value="come a get method for el">
	</form>
	<form action="demo.do" method="post">
		<input type="submit" value = "come a post method for jstl">
	</form>
	<p>this is a value showed by el expression:</p>
		
	${info}
	<hr>
	<p>this is about jstl:</p>
	<c:forEach items="${list }" var="fuck">
		${fuck}
	</c:forEach>
</body>
</html>