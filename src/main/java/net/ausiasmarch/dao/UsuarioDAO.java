package net.ausiasmarch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.Usuario;

public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }

    public Usuario get(int id) throws SQLException {
        String sql = "select * from usuario where id=?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2")
                    );
                } else {
                    throw new ResourceNotFoundException("Usuario con id "+id+" not found.");
                }
            }
        }
    }

    public List<Usuario> getAll() throws SQLException {

        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario";
        try(
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            if (rs.next()) { 
                do { 
                    usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2")
                    ));
                }while(rs.next());
            } else {
                throw new ResourceNotFoundException("No existen registros de usuarios todavía");
            }
        }
        return usuarios;
    }

    public void create(Usuario usuario) throws SQLException {
        String sql = "insert into usuario(username, nombre, apellido1, apellido2) values(?,?,?,?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getApellido1());
            pstmt.setString(4, usuario.getApellido2());
            pstmt.executeUpdate();
        }
    }

    public boolean usernameExists(String username) throws SQLException {
        String sql = "select username from usuario where username=?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, username);
            try(ResultSet rs = pstmt.executeQuery()){
                return rs.next();
            }
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "update usuario set nombre=?, apellido1=?, apellido2=? where id=?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido1());
            pstmt.setString(3, usuario.getApellido2());
            pstmt.setInt(4, usuario.getId());
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "delete from usuario where id=?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

