package net.ausiasmarch.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.Usuario;
import net.ausiasmarch.service.UsuarioService;

@WebServlet("/usuario-update")
public class UsuarioControllerPut extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("PUT".equalsIgnoreCase(method)) {
            doPut(request, response);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");

        UsuarioService usuarioService = new UsuarioService();
        
        try {
            Usuario usuario = usuarioService.get(id);
            usuario.setNombre(nombre);
            usuario.setApellido1(apellido1);
            usuario.setApellido2(apellido2);
            usuarioService.update(usuario);
            response.sendRedirect("form-update.jsp?update=1");

        } catch (SQLException | ResourceNotFoundException e) {
            request.setAttribute("errorMessage", "Error al obtener el usuario: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
