<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of users</title>
</head>
<body>
<jsp:include page="/WEB-INF/head.jsp"></jsp:include>
	<c:choose>
		<c:when test="${empty users}">
			<p> La liste des utilisateurs est vide</p>
		</c:when>
		<c:otherwise>
		<table border="1">
		<tr>
			<th>Login</th>
			<th>Prénom</th>
			<th>Nom </th>
			<th>Mot de passe </th>
			<th>Modifier </th>
			<th>Supprimer </th>
		</tr>
			<c:forEach items="${requestScope.users }" var="user">
				<tr>
					<td>${user.login}</td>
					<td>${user.lastName}</td>
					<td>${user.name}</td>
					<td>${user.password}</td>
					<td><a href="updateuser?id=${user.id}">Modifier</a></td>		
					<td><a href="deleteuser?id=${user.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose> 
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	
</body>
