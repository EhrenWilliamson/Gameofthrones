<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${player.firstName}${player.lastName}</title>
</head>
<body>
	<c:choose>
		<c:when test="${player != null}">
			Player id: ${player.id }
			<h1>${player.firstName}${player.lastName}</h1>
			<h3>${player.nickName}</h3>
			<h3>${player.status}</h3>
			<a href="goEditPlayerForm.do?id=${player.id}">Edit
				${player.firstName}</a>
			<a href="goDeletePlayer.do?id=${player.id}">Delete
				${player.firstName}</a>
			<a href="welcome.do">Home</a>
		</c:when>
		<c:otherwise>
			<h1>No Character Found!</h1>
			<a href="welcome.do">Return Home</a>
		</c:otherwise>
	</c:choose>
</html>