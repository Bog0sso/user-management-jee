<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

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
	<input type="text" placeholder="login" name="login" value="login"/>
	<input type="password" placeholder="password" name="password" value="password"/>
	<c:if test = "${ connexionFailed }">	
		<p class="error-login"> Login et/ou mot de passe incorrect(s)</p>
	
	</c:if>
	<input type="submit" value="Se connecter"/>
</fieldset>
</form>
</body>
</html>