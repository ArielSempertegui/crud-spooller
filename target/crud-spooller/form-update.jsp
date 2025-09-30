<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>Registro</title>
</head>
<body class="bg-light d-flex flex-column min-vh-100">
    <main class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="card shadow">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Actualizar usuario</h2>
                        <form method="post" action="usuario-update">
                            <input type="hidden" name="_method" value="PUT">
                            <div class="mb-3">
                                <label for="id" class="form-label">ID:</label>
                                <input type="number" class="form-control" id="id" placeholder="Introduce el ID de un usuario" name="id" required>
                            </div>
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" required>
                            </div>
                            <div class="mb-3">
                                <label for="apellido1" class="form-label">Primer Apellido</label>
                                <input type="text" class="form-control" id="apellido1" name="apellido1" required>
                            </div>
                            <div class="mb-3">
                                <label for="apellido2" class="form-label">Segundo Apellido</label>
                                <input type="text" class="form-control" id="apellido2" name="apellido2" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Actualizar</button>
                            </div>
                        </form>

                        <c:if test="${param.update == '1'}">
                            <div class="alert alert-success mt-3 text-center" role="alert">
                                Usuario actualizado !
                            </div>
                        </c:if>
                        <a href="index.jsp" class="btn btn-outline-primary mt-3">Volver a la página principal</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
