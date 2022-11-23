<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<nav>
		<ul>
		<c:choose>
		<c:when test="${isConnected}">
			<li><a href="/user-management/users">Utilisateurs</a></li>
			<li><a href="/user-management/adduser">Ajouter</a></li>
			<li><a href="/user-management/logout">Se déconnecter</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/user-management/login">Se connecter</a></li>
		</c:otherwise>
		
		</c:choose>
		</ul>
	</nav>
</head>