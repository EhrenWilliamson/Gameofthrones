<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${house.houseName}</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty house}">
			<h1>${house.houseName}</h1>
			<h3>${house.location}</h3>
			<h3>${house.headOfHouse}</h3>
			<a href="goEditHouseForm.do?id=${house.id}">Edit
				${house.houseName}</a>
			<a href="goDeleteHouse.do?id=${house.id}">Delete
				${house.houseName}</a>
			<a href="welcome.do">Home</a>
		</c:when>
		<c:otherwise>
			<h1>House not found!</h1>
			<a href="welcome.do">Return Home</a>
		</c:otherwise>
	</c:choose>
</body>
</html>