<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of users</title>
</head>
<body>

	<%
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
	if(users.isEmpty()){%>
		<p> La liste des utilisateurs est vide</p>
	<%
	}else {%>
		<table border="1">
		<tr>
			<th>Login</th>
			<th>Prénom</th>
			<th>Nom </th>
			<th>Mot de passe </th>
			<th>Modifier </th>
			<th>Supprimer </th>
		</tr>
		<%
		for(User u : users){%>
			<tr>
				<td><%= u.getLogin() %></td>
				<td><%= u.getName() %></td>
				<td><%= u.getLastName() %></td>
				<td><%= u.getPassword() %> </td>
				<td> <a href="updateuser?id=<%=u.getId()%>">Modifier</a> </td>
				<%-- <td><%= u.getId() %></td> --%>
				<td> <a href="deleteuser?id=<%=u.getId()%>">Supprimer</a></td>
			</tr>			
			
		<%}
		%>
		</table>
	<%}
	%>
</body>
