<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a New Character</title>
</head>
<body>
	<form action="newplayer.do" method=POST>
		Character First Name: <input type="text" name="firstName" /><br>
		Character Last Name: <input type="text" name="lastName" /><br>
		Character Nickname: <input type="text" name="nickName" /><br>
		<button type="submit" value="Edit Character">Save New Character
			${player.firstName}</button>
	</form>
	<a href="welcome.do">Home</a>

</body>
</html>