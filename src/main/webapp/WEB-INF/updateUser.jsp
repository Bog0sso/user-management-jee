<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
</head>
<body>

	<form action="updateuser?id=${user.id}" METHOD="POST">
	
		<label for ="login" >
			Login:
			<input type="text" id="login" name="login" value="${user.login}"/>
		</label>
		
		<label for ="name" >
			Prénom:
			<input type="text" id="name" name="name" value="${user.name}" />
		</label>
		
		<label for ="lastName" >
			Nom:
			<input type="text" id="lastName" name="lastName" value="${user.lastName}" />
		</label>
		
		<label for ="password" >
			Mot de passe:
			<input type="text" id="password" name="password" value="${user.password}" />
		</label>
		
		<button type="submit">Mettre à jour</button>
		
	</form>
</body>
</html>