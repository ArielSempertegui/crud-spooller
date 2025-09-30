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

@WebServlet("/usuario")
public class UsuarioControllerGet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioService usuarioService = new UsuarioService();

        try {
            Usuario usuario = usuarioService.get(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);
        } catch (SQLException | ResourceNotFoundException e) {
            request.setAttribute("errorMessage", "Error al obtener el usuario: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
