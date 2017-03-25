<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a New House</title>
</head>
<body>
	<form action="newhouse.do" method="GET">
		House Name: <input type="text" name="houseName"/><br>
		Castle Name: <input type="text" name="castleName"/><br>
		House Location: <input type="text" name="location"/><br>
		Head of House: <input type="text" name="headOfHouse"/><br> 
		<button type="submit" value="Add New House"></button>		
	</form>
	<a href="home.do">Home</a>
</body>
</html>