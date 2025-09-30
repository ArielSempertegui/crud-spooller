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

@WebServlet("/usuarios")
public class UsuarioControllerGetAll extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        UsuarioService usuarioService = new UsuarioService();

        try {
            List<Usuario> usuarios = usuarioService.getAll();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("form-delete.jsp").forward(request, response);
        } catch (SQLException | ResourceNotFoundException e) {
            request.setAttribute("errorMessage", "Error al obtener a los usuarios: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
