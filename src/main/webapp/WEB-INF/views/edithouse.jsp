<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit ${house.name}</title>
</head>
<body>

<a href="http://localhost:3306/GoTDB"></a>
<h1>Editing ${house.name}</h1>
	<form action="editHouse.do" method="POST">
		House: <input type="text" name="house" /> <input type="submit"
			value="Search" />
			
			
		House Name: <input type="text" name="name" value="${house.name}"/><br>
		House Location: <input type="text" name="location" value="${house.location}"/><br>
		Head of House: <input type="text" name="headOfHouse" value="${house.headOfHouse}"/><br> 
		<button type="submit" value="Edit Operator">Save changes to ${house.name}</button>
		
	</form>
	
	
	
</body>
</html>