<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
	<div class="container">
		<h2>Welcome to login page!</h2>
		<hr>
		<h1>Login</h1>
		<pre style="color: red; font-weight: bold; font-size: 1.3rem">${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name"> Password: <input
				type="password" name="password"> <input type="submit">
		</form>
	</div>
</body>
</html>