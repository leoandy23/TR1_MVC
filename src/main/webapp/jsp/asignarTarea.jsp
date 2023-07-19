<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <span class="navbar-brand mb-0 h1">Administrador</span>
      </div>
    </nav>
    <!-- Navbar End -->

    <!-- Form Start -->
    <div class="container my-3">
      <form action="" class="w-50 mx-auto shadow p-3 rounded">
        <h2>Asignar tarea</h2>
        <div class="input-group mb-3">
          <label class="input-group-text" for="idtask">ID Tarea:</label>
          <input
            id="idtask"
            name="idtask"
            type="text"
            class="form-control"
            placeholder="Ingrese el nombre de la tarea"
            value="1"
            disabled />
        </div>
        <div class="input-group mb-3">
          <label class="input-group-text" for="taskname">Nombre Tarea:</label>
          <input
            id="taskname"
            name="taskname"
            type="text"
            class="form-control"
            placeholder="Ingrese el nombre de la tarea"
            value="Hacer planillas"
            disabled />
        </div>
        <div class="input-group mb-3">
          <label class="input-group-text" for="taskname"
            >Responsable de la tarea:</label
          >
          <select
            class="form-select"
            aria-label="Default select example"
            name="responsable-task">
            <option value="1" selected>Por asignar</option>
            <option value="2">Luis Perez</option>
            <option value="3">Pedro Montalvo</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">
          Guardar Asignación
        </button>
      </form>
    </div>
    <!-- Form End -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
