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
	<form action="newhouse.do" method="POST">
		House Name: <input type="text" name="name"/><br>
		House Location: <input type="text" name="location"/><br>
		Head of House: <input type="text" name="headOfHouse"/><br> 
		<button type="submit" value="Edit Operator">Save changes to ${house.name}</button>
		
		
		
		<button type="submit" value="Add Operator">Save changes</button>
	</form>
</body>
</html>