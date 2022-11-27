<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
</head>
<body>
	<p>${statusMessage}</p>
	<form action="adduser" METHOD="post">
	
		<label for ="login" >
			Login:
			<input type="text" id="login" name="login" value = "${user.login }" />
			<span class="error-input-message">${errors.login}</span>

		</label>
		
		<label for ="name" >
			Prénom:
			<input type="text" id="name" name="name" value = "${user.name }"/>
			<span class="error-input-message">${errors.name}</span>

		</label>
						
		<label for ="lastName" >
			Nom:
			<input type="text" id="lastName" name="lastName" value = "${user.lastName }"/>
			<span class="error-input-message">${errors.lastName}</span>

		</label>
		
		<label for ="password" >
			Mot de passe:
			<input type="text" id="password" name="password"/>
			<span class="error-input-message">${errors.password}</span>

		</label>

		
		<label for ="password-confirmation" >
			Mot de passe:
			<input type="text" id="password-confirmation" name="passwordConfirmation"/>
			<span class="error-input-message">${errors.passwordConfirmation}</span>

		</label>
				
		<button type="submit">Ajouter utilisateur</button>
		
	</form>
</body>
</html>