<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body>
	<!-- Login Form Start -->
	<div class="container">
		<div class="w-50 mx-auto my-5 rounded shadow bg-light-subtle p-3">
			<h3 class="text-center">Iniciar sesion</h3>
			<form action="">
				<div class="input-group mb-3">
					<label class="input-group-text" id="basic-addon1" for="username">Usuario</label>
					<input id="username" name="username" type="text"
						class="form-control" placeholder="Username" aria-label="Username"
						aria-describedby="basic-addon1" />
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" id="basic-addon1" for="pswd">Contraseña</label>
					<input id="pswd" name="pswd" type="password" class="form-control"
						placeholder="Contraseña" aria-label="Contraseña"
						aria-describedby="basic-addon1" />
				</div>
				<input type="submit" value="Iniciar sesion" class="btn btn-primary" />
			</form>
		</div>
	</div>
	<!-- Login Form End -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
