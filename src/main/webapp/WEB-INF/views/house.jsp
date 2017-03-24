<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${house.name}</title>
</head>
<body>
	<h1>${house.name}</h1>
	<h3>${house.location}</h3>
	<h3>${house.headOfHouse}</h3>
	
	<c:forEach var="house" items="${houses}">
		<h2><a href="retrieve.do?abr=${house.id}">${house.name}</a></h2><br>
	</c:forEach>
</body>
</html>