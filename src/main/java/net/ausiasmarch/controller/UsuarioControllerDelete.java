package net.ausiasmarch.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.Usuario;
import net.ausiasmarch.service.UsuarioService;

@WebServlet("/usuario-delete")
public class UsuarioControllerDelete extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("DELETE".equalsIgnoreCase(method)) {
            doDelete(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioService usuarioService = new UsuarioService();

        try {
            usuarioService.delete(id);
            List<Usuario> usuarios = usuarioService.getAll();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("form-delete.jsp").forward(request, response);
        } catch (SQLException | ResourceNotFoundException e) {
            request.setAttribute("errorMessage", "Error al refrescar la página: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
