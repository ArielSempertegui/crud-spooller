<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio - Mondublio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>

<body class="bg-light d-flex flex-column min-vh-100">
    <main class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h1 class="card-title mb-4">Bienvenido a CRUD-Spooller</h1>
                        <h4 class="card-title mb-4">Practicando CRUD con bases de datos, JDBC, Pool y páginas dinámicas</h4>
                        <p class="mb-4">Selecciona una opción:</p>
                        <div class="d-grid gap-3">
                            <a href="form-select.html" class="btn btn-outline-primary">
                                Mostrar un usuario<br>
                                <span class="small text-warning">Elige un usuario para ver sus datos</span>
                            </a>
                            <a href="usuarios" class="btn btn-outline-primary">
                                Mostrar todos los usuarios<br>
                                <span class="small text-warning">Podrás ver una lista de todos los usuarios</span>
                            </a>
                            <a href="form-create.jsp" class="btn btn-outline-primary">
                                Crea un usuario<br>
                                <span class="small text-warning ">Llena los datos del formulario para crear un usuario</span>
                            </a>
                            <a href="form-update.jsp" class="btn btn-outline-primary">
                                Actualizar un usuario<br>
                                <span class="small text-warning">Llena los datos del formulario para actualizar los datos de un usuario</span>
                            </a>
                            <!-- <a href="usuarios" class="btn btn-outline-primary">
                                Borrar un usuario<br>
                                <span class="small text-warning">Elimina un usuario de la lista</span>
                            </a> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>