<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit ${house.houseName}</title>
</head>
<body>

<h1>Editing ${house.houseName}</h1>
	<form action="editHouse.do" method="POST">
		House Name: <input type="text" name="name" value="${house.houseName}"/><br>
		Castle Name: <input type="text" name="name" value="${house.castleName}"/><br>
		House Location: <input type="text" name="location" value="${house.location}"/><br>
		Head of House: <input type="text" name="headOfHouse" value="${house.headOfHouse}"/><br> 
		<button type="submit" value="Edit">Save changes to ${house.houseName}</button>
	</form>
	<a href="welcome.do">Home</a>	
</body>
</html>