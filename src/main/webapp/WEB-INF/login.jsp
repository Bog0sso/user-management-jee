<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<jsp:include page="/WEB-INF/head.jsp"></jsp:include>

<form method="POST" action="/user-management/login">
<fieldset>
	<legend>Connexion</legend>
	<input type="text" placeholder="login" name="login"/>
	<input type="password" placeholder="password" name="password"/>
	<input type="submit" value="Se connecter"/>
</fieldset>
</form>
</body>
</html>