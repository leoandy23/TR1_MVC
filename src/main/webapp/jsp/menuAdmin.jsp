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
    <div class="container my-3">
      <!-- Search Start -->
      <div class="input-group mb-3">
        <label class="input-group-text" for="buscador">Buscar</label>
        <input
          id="buscador"
          type="text"
          class="form-control"
          placeholder="Ingrese el nombre de la tarea a buscar"
          aria-label="Buscar"
          aria-describedby="buscador" />
      </div>
      <!-- Search End -->
      <!-- Table Start -->
      <div>
        <a href="#" class="btn btn-outline-primary"
          ><i class="fa fa-plus"></i> Crear tarea</a
        >
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Código</th>
              <th>Nombre</th>
              <th>Responsable</th>
              <th>Estado</th>
              <th>Acción</th>
            </tr>
          </thead>
          <tbody>
            <tr class="task-item">
              <td>1</td>
              <td>Realizar planillas</td>
              <td>-</td>
              <td>Por asignar</td>
              <td class="text-center">
                <a href="#" class="btn btn-primary">Asignar</a>
              </td>
            </tr>
            <tr class="task-item">
              <td>2</td>
              <td>Revision de becas</td>
              <td>Luis Perez</td>
              <td>Por completar</td>
              <td class="text-center">-</td>
            </tr>
            <tr class="task-item">
              <td>3</td>
              <td>Historiales medicos</td>
              <td>Pedro Montalvo</td>
              <td>Completado</td>
              <td class="text-center">-</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- Table End -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
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
