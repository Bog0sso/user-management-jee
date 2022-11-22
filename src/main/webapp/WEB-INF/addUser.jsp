<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
</head>
<body>
	<form action="adduser" METHOD="post">
	
		<label for ="login" >
			Login:
			<input type="text" id="login" name="login"/>
		</label>
		
		<label for ="name" >
			Prénom:
			<input type="text" id="name" name="name"/>
		</label>
		
		<label for ="lastName" >
			Nom:
			<input type="text" id="lastName" name="lastName"/>
		</label>
		
		<label for ="password" >
			Mot de passe:
			<input type="text" id="password" name="password"/>
		</label>
		
		<button type="submit">Ajouter utilisateur</button>
		
	</form>
</body>
</html>