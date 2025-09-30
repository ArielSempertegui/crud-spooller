package net.ausiasmarch.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.ausiasmarch.connection.HikariPool;
import net.ausiasmarch.dao.UsuarioDAO;
import net.ausiasmarch.model.Usuario;

public class UsuarioService {
    
    public Usuario get(int id) throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            return new UsuarioDAO(connection).get(id);
        }
    }

    public List<Usuario> getAll() throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            return new UsuarioDAO(connection).getAll();
        }
    }

    public void create(Usuario usuario) throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            new UsuarioDAO(connection).create(usuario);
        }
    }

    public boolean usernameExists(String username) throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            return new UsuarioDAO(connection).usernameExists(username);
        }

    }

    public void update(Usuario usuario) throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            new UsuarioDAO(connection).update(usuario);
        }
    }

    public void delete(int id) throws SQLException {
        try(Connection connection = HikariPool.getPool().getConnection()){
            new UsuarioDAO(connection).delete(id);
        }
    }
}
