<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Westeros</title>
</head>
<body>
	<form action="gethousebyname.do" method="GET">
		House: <input type="text" name="house" /> <input type="submit"
			value="Search" />
	</form>
	<form action="getplayerbyname.do" method="GET">
		Character: <input type="text" name="player" /> <input type="submit"
			value="Search" />
	</form>
	<a href="goNewHouseForm.do">Add a New House</a><br>
	<a href="goNewPlayerForm.do">Add a New Character</a><br>
	
<%-- 	<c:forEach var="house" items="${houses}">
		<h2><a href="retrieve.do?abr=${house.id}">${house.houseName}</a></h2><br>
	</c:forEach> --%>
</body>
</html>