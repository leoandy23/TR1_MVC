<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Director</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
	integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<!-- Navbar Start -->
	<nav class="navbar bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Director: <c:out value="${director.nombre}"/></span>
			<a href="CerrarSesionController" class="btn btn-danger">Cerrar Sesi�n</a>
		</div>
	</nav>
	<!-- Navbar End -->
	<div class="container my-3">
		<!-- Search Start -->
		<div class="input-group mb-3">
			<label class="input-group-text" for="buscador">Buscar</label> <input
				id="buscador" type="text" class="form-control"
				placeholder="Ingrese el nombre de la tarea a buscar"
				aria-label="Buscar" aria-describedby="buscador" />
		</div>
		<!-- Search End -->
		<!-- Table Start -->
		<div>
			<a href="CrearTareaController" class="btn btn-outline-primary">
				<i class="fa fa-plus"></i> Crear tarea
			</a>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>C�digo</th>
						<th>Nombre</th>
						<th>Estado</th>
						<th>Responsable</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tareas}" var="tarea">
						<tr class="task-item">
							<td scope="row">${tarea.codigo}</td>
							<td>${tarea.nombre}</td>
							<td>${tarea.estado}</td>
							<c:if test="${empty tarea.responsable}">
								<td><a href="AsignarTareaController?codigoTarea=${tarea.codigo}" class="btn btn-primary">Asignar</a>
								</td>
							</c:if>
							<c:if test="${not empty tarea.responsable}">
								<td>${tarea.responsable.nombre}</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Table End -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
      $("#buscador").on("input", function () {
        const task_search = $(this).val().toLowerCase();

        $(".task-item").each(function () {
          const task_name = $(this)
            .find("td:nth-child(2)")
            .text()
            .toLowerCase();
          if (task_name.includes(task_search)) {
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      });
    </script>
</body>
</html>
