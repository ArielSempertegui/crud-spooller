package net.ausiasmarch.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ausiasmarch.model.Usuario;
import net.ausiasmarch.service.UsuarioService;

@WebServlet("/usuario-create")
public class UsuarioControllerPost extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String username = request.getParameter("username");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");

        Usuario usuario = new Usuario(username, nombre, apellido1, apellido2);
        UsuarioService usuarioService = new UsuarioService();
        
        try{
            if (usuarioService.usernameExists(username)) {
                response.sendRedirect("form-create.jsp?errorCreate=1");
            } else {
                usuarioService.create(usuario);
                response.sendRedirect("form-create.jsp?create=1");
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Error al crear un usuario: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }    
    }
}
