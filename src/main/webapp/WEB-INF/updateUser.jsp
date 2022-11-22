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
<%
	User user = (User)request.getAttribute("user");
%>
	<form action="updateuser?id=<%=user.getId()%>" METHOD="POST">
	
		<label for ="login" >
			Login:
			<input type="text" id="login" name="login" value="<%=user.getLogin()%>"/>
		</label>
		
		<label for ="name" >
			Prénom:
			<input type="text" id="name" name="name" value="<%=user.getName()%>" />
		</label>
		
		<label for ="lastName" >
			Nom:
			<input type="text" id="lastName" name="lastName" value="<%=user.getLastName()%>" />
		</label>
		
		<label for ="password" >
			Mot de passe:
			<input type="text" id="password" name="password" value="<%=user.getPassword()%>" />
		</label>
		
		<button type="submit">Mettre à jour</button>
		
	</form>
</body>
</html>