<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body class="bg-light">
    <main class="container py-5">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <h1 class="card-title text-center mb-4">Usuarios</h1>
                        <!-- ejercicio 1: comentario en HTML -->       
                        <div class="mb-3">
                            <div class="alert alert-primary">
                                <strong>Lista de Usuarios</strong>
                            </div>
                            <div>
                                <c:forEach var="usuario" items="${usuarios}">
                                    <form method="post" action="usuario-delete">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="hidden" name="id" value="${usuario.id}">
                                        <%@ include file="parameters_usuario.jsp" %>
                                        <button type="submit" class="btn btn-primary">Eliminar</button>
                                    </form>
                                </c:forEach>
                            </div>
                            <a href="index.jsp" class="btn btn-outline-primary mt-3">Volver a la página principal</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
