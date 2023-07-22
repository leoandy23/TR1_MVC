<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administrador</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer" />
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
      integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"></script>
  </head>
  <body>
    <!-- Navbar Start -->
    <nav class="navbar bg-body-tertiary">
      <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Administrador: <c:out value="${nombreDirector}"/></span>
      </div>
    </nav>
    <!-- Navbar End -->

    <!-- Form Start -->
    <div class="container my-3">
      <form action="CrearTareaController" method="POST" class="w-50 mx-auto shadow p-3 rounded">
        <h2>Crear tarea</h2>
        <div class="input-group mb-3">
          <label class="input-group-text" for="taskname">Nombre Tarea:</label>
          <input
            id="taskname"
            name="taskname"
            type="text"
            class="form-control"
            placeholder="Ingrese el nombre de la tarea" 
            required/>
        </div>
        <button type="submit" class="btn btn-primary">Crear Tarea</button>
        <a href="MenuDirectorController" class="btn btn-secondary">Volver al Menú</a>
      </form>
    </div>
    
	<script>
	  function validateForm() {
	    const taskname = document.getElementById('taskname').value.trim();
	    
	    // Verificar si el campo está vacío
	    if (taskname === '') {
	      alert('El campo "Nombre Tarea" no puede estar vacío.');
	      return false; // Detener el envío del formulario
	    }
	
	    // Si pasa la validación, el formulario se enviará
	    return true;
	  }
	</script>
    <!-- Form End -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
