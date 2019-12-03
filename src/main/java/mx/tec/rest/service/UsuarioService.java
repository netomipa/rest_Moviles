package mx.tec.rest.service;

import mx.tec.rest.model.Usuario;
import mx.tec.rest.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService implements IUsuarioService {

    @Override
    public List<Usuario> findUsuarios() {
        String sql = "SELECT idUsuario, correo, password FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setPassword(resultSet.getString("password"));
                usuarios.add(usuario);
            }
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public Usuario findUsuarioById(int idUsuario) {
        String sql = "SELECT idUsuario, correo, password FROM Usuario WHERE idUsuario=?";
        Usuario usuario = new Usuario();
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            usuario.setIdUsuario(resultSet.getInt("idUsuario"));
            usuario.setCorreo(resultSet.getString("correo"));
            usuario.setPassword(resultSet.getString("password"));
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return usuario;
    }

    @Override
    public boolean validarUsuario(String coreo) {
        String sql = "SELECT idUsuario FROM Usuario WHERE correo=?";
        boolean result = true;
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, coreo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                result = false;

            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return result;
    }

    @Override
    public Usuario validarSesion(Usuario usuario) {
        String sql = "SELECT idUsuario FROM Usuario WHERE correo=? AND password=SHA2(?,256)";
        // boolean result = false;
        Usuario result = new Usuario();
        result.setIdUsuario(0);
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getCorreo());
            preparedStatement.setString(2, usuario.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                result.setIdUsuario(resultSet.getInt("idUsuario"));
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteUsuario(int idUsuario) {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";
        boolean result = false;
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.execute();
            result = true;
            conexion.close();
            preparedStatement.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean createUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario(correo, password) VALUES(?,SHA2(?,256))";
        boolean resultado = false;
        try{
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getCorreo());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.execute();
            resultado = true;
            conexion.close();
            preparedStatement.close();
        }catch(Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean editUsuario(Usuario usuario) {
            String sql = "UPDATE Usuario SET correo=?, password=SHA2(?,256) WHERE idUsuario=?";
            boolean result = false;
            try{
                Connection conexion = Conexion.getConexion();
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getCorreo());
                preparedStatement.setString(2, usuario.getPassword());
                preparedStatement.setInt(3,usuario.getIdUsuario());
                preparedStatement.execute();

                result = true;
                conexion.close();
                preparedStatement.close();
            }catch(Exception ex)
            {
                System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
            }
            return result;
    }
}
