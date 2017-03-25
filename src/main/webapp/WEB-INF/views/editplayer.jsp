<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit ${player.name}</title>
</head>
<body>

<a href="welcome.do">Player</a>
<h1>Editing ${house.name}</h1>
	<form action="editPlayer.do" method="POST">
		First Name: <input type="text" name="name" value="${player.firstName}"/><br>
		Last Name: <input type="text" name="name" value="${player.lastName}"/><br>
		Nickname: <input type="text" name="location" value="${player.nickName}"/><br>
		Status: <input type="text" name="headOfHouse" value="${player.status}"/><br> 
		<button type="submit" value="Edit">Save changes to ${player.firstName}</button>
	</form>
</body>
</html>